package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.exception.InvalidCardException;


@RestController
public class paymentController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(paymentController.class);
	private final String USER_AGENT = "Mozilla/5.0";
	  
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
	
	@PostMapping("/paymentProcessor")
	public ModelAndView paymentProcessor(HttpServletRequest request) throws IOException, InvalidCardException, ArithmeticException{

//      ############################ Fetching details from UI ##################################		
		String merchantId=request.getParameter("merchant");
		String cardNo=request.getParameter("cardNo");
		String expiryDate=request.getParameter("expiryDate");
		String cvv=request.getParameter("cvv");
		String bill=request.getParameter("bill");
		String pin=request.getParameter("pin");


//      ############################# Primary Validation #######################################		
		String Visa = "^4[0-9]{12}(?:[0-9]{3})?$";
		String Maestro = "^(5018|5020|5038|6304|6759|6761|6763)[0-9]{8,15}$";
		String JCB = "^(?:2131|1800|35\\d{3})\\d{11}$";
		String UnionPay = "^(62[0-9]{14,17})$";
		String Amex = "^3[47][0-9]{13}$";

		//primary card validation
		if (!(cardNo.matches(Visa) || cardNo.matches(Maestro) || cardNo.matches(JCB) || cardNo.matches(UnionPay) || cardNo.matches(Amex))) {
			System.out.println("invalid card");
			throw new InvalidCardException("invalid card");
		} else {
			System.out.println("valid card");
		}
		
		//primary pin validation
		if (pin.length()==4 || pin.length()==6) {
			System.out.println("valid pin");
		} else {
			System.out.println("Invalid pin format");
			throw new InvalidCardException("invalid card");
		}
		
		//primary expire date validation
		LocalDate localDate = LocalDate.now();
		String local = DateTimeFormatter.ofPattern("MMyy").format(localDate).toString();
		int expmonth = Integer.parseInt(expiryDate.substring(0, 2));
		int expyear = Integer.parseInt(expiryDate.substring(2));
		int currentmonth = Integer.parseInt(local.substring(0, 2));
		int currentyear = Integer.parseInt(local.substring(2));
		
		if(expmonth >= 1 && expmonth <= 12) 
		{
			if(expyear > currentyear) 
			{
				System.out.println("valid expire date");
			}
			else if(expyear == currentyear) 
			{
				if(expmonth >= currentmonth) 
				{
					System.out.println("valid expire date");
				}
				else 
				{
					System.out.println("Invalid expire date");
					throw new InvalidCardException("invalid card");
				}
			}
			else
			{
				System.out.println("Invalid expire date");
				throw new InvalidCardException("invalid card");
			}
		}
		else {
			System.out.println("Invalid expire date");
			throw new InvalidCardException("invalid card");
		}
		
		//primary cvv validation
		if (cvv.length()==3) {
			System.out.println("acceptable cvv");
		} else {
			System.out.println("Invalid cvv format, Cvv should be 3 digit");
			throw new InvalidCardException("invalid card");
		}
		
		//primary bill validation
		if(Integer.parseInt(bill)>0) {
			System.out.println("positive amount");
		}
		else {
			System.out.println("negative amount");
			throw new ArithmeticException("########## You Entered Negative Amount ##########");
		}
		
//		################################# Connection to Simulator ##############################################
		String details = merchantId+"_"+cardNo+"_"+expiryDate+"_"+cvv+"_"+bill;
		
		System.out.println("Done!!");
		
		//send to Simulator
		
		URL url = new URL("http://localhost:9090/paymentSimulator");
		  HttpURLConnection con = (HttpURLConnection) url.openConnection(); 
		  // add request header 
		  con.setRequestMethod("POST");
		  con.setRequestProperty("User-Agent", USER_AGENT);
		  con.setRequestProperty("Content-Type", "application/json; utf-8");
		  con.setRequestProperty("Accept", "application/json"); con.setDoOutput(true);
		  
		  String jsonInputString ="{\"merchantId\":\""+merchantId+"\",\"cardNo\": \""+cardNo+"\",\"expiryDate\": \""+expiryDate+"\",\"cvv\": \""+cvv+"\",\"pin\": \""+pin+"\",\"bill\":\""+bill+"\"}"; 
		  //String jsonInputString="{\"cardNo\":"+cardreq.getCardNo()+"\",\"expire_date\":"+cardreq.getExpireDate() + "\"expire_date\":" + cardreq.getCvv()+"\"expire_date\":" + cardreq.getPin() + "\"}" ; 
		  //String jsonInputString="{\"cardNo\":\"cardreq.getCardNo()\",\"expire_date\": \"cardreq.getExpireDate()\",\"cvv\": \"cardreq.getCvv()\",\"pin\":\"cardreq.getPin()\"}";
		  
		  try (OutputStream os = con.getOutputStream()) { 
			  byte[] input=jsonInputString.getBytes("utf-8"); 
			  String str = new String(input);
			  os.write(input); 
		  }
		  
		  try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) { 
			  StringBuilder response =new StringBuilder(); 
			  String responseLine = null; 
			  while ((responseLine=br.readLine()) != null) { 
				  response.append(responseLine.trim()); 
				  }
			  String finalResponse =response.toString(); 
			  System.out.println(finalResponse);
			  
			  String[] finalResponseArray=finalResponse.split("_");
			  
			  ModelAndView mv=new ModelAndView();
			  
			  if(finalResponseArray[0].contentEquals("300"))
			  {
				  System.out.println("Insuffient Funds");
				  mv.addObject("Message", finalResponseArray[1]);
				  mv.addObject("TransactionId", finalResponseArray[3]);
				  mv.addObject("Payment", finalResponseArray[5]);
				  mv.addObject("Time", finalResponseArray[6]);
				  mv.setViewName("Failure");
			  }
			  else if(finalResponseArray[0].contentEquals("200"))
			  {
				  System.out.println("Payment successful");
				  mv.addObject("Name", finalResponseArray[2]);
				  mv.addObject("TransactionId", finalResponseArray[3]);
				  mv.addObject("AccountNo", finalResponseArray[4]);
				  mv.addObject("Payment", finalResponseArray[5]);
				  mv.addObject("Time", finalResponseArray[6]);
				  mv.setViewName("Success");
			  }
			  else
			  {
				  System.out.println("Card details does not match");
				  mv.addObject("Message", finalResponseArray[1]);
				  mv.setViewName("Unauthorize");
			  }
			  
			  return mv;
			  
		  }

	}
}
