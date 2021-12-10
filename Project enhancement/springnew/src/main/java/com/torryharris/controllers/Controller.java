package com.torryharris.controllers;

import com.torryharris.DAO.Train;
import com.torryharris.DAO.TrainDAO;
import com.torryharris.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
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
   private Ticket ticket;

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


    @GetMapping("/payment")
    public String payment()
    {
        return "payment";
    }

    @GetMapping("/find")
    public ModelAndView bookTicket(HttpServletRequest request)
    {
        int num = Integer.parseInt(request.getParameter("trainNo"));
        ModelAndView mv = new ModelAndView();
        mv.addObject("num",num);
        mv.setViewName("find");
        return mv;
    }

    @GetMapping("/select")
    public ModelAndView selectTrain(HttpServletRequest request, HttpServletResponse response)
    {
        List<Train>trainList=trainDAO.loadTrains();
        ModelAndView mv=new ModelAndView();
        mv.setViewName("form1");
        mv.addObject("trains",trainList);
        return mv;
    }


    @GetMapping("/add")
    public String addTrain(Model mv)
    {
        Train train =new Train();
        mv.addAttribute("train",train);
        return "add";
    }

    @GetMapping("/save")
    public String save(Train train)
    {
        if(train.getTrainNo()==0)
        {
            //inserting a new record
            trainDAO.saveTrain(train);
        }
        else{
            //update
            trainDAO.update(train);
        }
        return "redirect:/showtrain";
    }
    @GetMapping("/update")
    public String updateTrain(@RequestParam("trainNo") int num,Model mv)
    {
        Train train1=trainDAO.getTrain(num);
        System.out.println(train1);
        mv.addAttribute("train",train1);
        return "add";
    }

    @GetMapping("/delete")
    public String deleteTrain(@RequestParam("trainNo") int num)
    {
        trainDAO.deleteTrain(num);
        return "redirect:/showtrain";
    }

    @GetMapping("/take")
    public ModelAndView findTrain(HttpServletRequest request ) throws ParseException {
        ModelAndView mv=new ModelAndView();
        int num1 = Integer.parseInt(request.getParameter("trainNo"));
        String name = request.getParameter("name");
        Integer age = Integer.parseInt(request.getParameter("age"));
        String genders = request.getParameter("gender");
        Character gender = genders.charAt(0);
        Train train= trainDAO.getTrain(num1);
        String date =request.getParameter("date");
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        ticket.setTravelDate(date1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String travelDate=simpleDateFormat.format(date1);
        String PNR=null;
        Double amount=0.0;
        ticket.setTrain(train);
        char s=train.getSource().charAt(0);
        char d=train.getDestination().charAt(0);
        String pnr=""+s+d+"_"+travelDate+"_"+100;
        PNR=pnr;

        Double fare=train.getTicketPrice();
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


        ticket.addPassenger(name,age,gender);

        // System.out.println(PNR);

            mv.setViewName("book");

           mv.addObject("find", train);
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

//    @GetMapping("/download")
//    public String downloadTicket() throws IOException {
//        ticket.writeTicket();
//        ticket.setCounter(ticket.getCounter()+1);
//        return "confirm";
//    }
}





