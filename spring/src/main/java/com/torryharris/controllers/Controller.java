package com.torryharris.controllers;

import com.torryharris.DAO.Train;
import com.torryharris.DAO.TrainDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

   @Autowired
    private TrainDAO trainDAO;

    @GetMapping("/showtrain")
    public ModelAndView showTrain(HttpServletRequest request, HttpServletResponse response)
    {
        List<Train>trainList=trainDAO.loadTrains();
        ModelAndView mv=new ModelAndView();
        mv.setViewName("form");
        mv.addObject("trains",trainList);
        return mv;
    }


    @GetMapping("/find")
    public String bookTicket()
    {
        return "find";
    }

    @GetMapping("/take")
    public ModelAndView findTrain(HttpServletRequest request, HttpServletResponse response ) throws ParseException {
        ModelAndView mv=new ModelAndView();
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int counter=100;

            String name = request.getParameter("name");
            Integer age = Integer.parseInt(request.getParameter("age"));
            String genders = request.getParameter("gender");
            Character gender = genders.charAt(0);


        List<Train>trainList= trainDAO.loadTrains(num1);
        String date =request.getParameter("date");
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String travelDate=simpleDateFormat.format(date1);


        String PNR=null;
        Double amount=0.0;
        for (Train trains:trainList){
            char s=trains.getSource().charAt(0);
            char d=trains.getDestination().charAt(0);
            String pnr=""+s+d+"_"+travelDate+"_"+ ++counter;
            PNR=pnr;

            Double fare=trains.getTicketPrice();
            if(age>= 60){
                fare=fare*0.4;
            }else if(gender == 'F'){
                fare=fare* 0.75;
            }else if(age <= 12){
                fare=fare* 0.5;
            }else {
                fare=fare;
            }
            amount=fare;
        }

        // System.out.println(PNR);

            mv.setViewName("book");

            mv.addObject("find", trainList);
            //mv.addObject("pass",pass);
             mv.addObject("pnr", PNR);
              mv.addObject("amount", amount);
       // mv.addObject("list",list);
            mv.addObject("name", name);
            mv.addObject("age", age);
            mv.addObject("gender", gender);
            mv.addObject("date",date);

        return mv;
    }

    @GetMapping("/confirm")
    public ModelAndView confirm(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new ModelAndView();
        String pnr = request.getParameter("pnr");


        String date = request.getParameter("date");

        Integer trainNo = Integer.parseInt(request.getParameter("trainNo"));
        Double amount = Double.parseDouble(request.getParameter("amount"));
        String trainName=request.getParameter("trainName");
        String source=request.getParameter("source");
        String destination=request.getParameter("destination");

        String name = request.getParameter("name");
        Integer age = Integer.parseInt(request.getParameter("age"));
        String genders = request.getParameter("gender");
        Character gender= genders.charAt(0);





        mv.addObject("pnr",pnr);
        mv.addObject("trainNo",trainNo);
        mv.addObject("amount",amount);
         mv.addObject("trainName",trainName);
        mv.addObject("source",source);
        mv.addObject("destination",destination);
        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.addObject("gender",gender);

        mv.addObject("date",date);
        mv.setViewName("confirm");
        return mv;
    }



    }

