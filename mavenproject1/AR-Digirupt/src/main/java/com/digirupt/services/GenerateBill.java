/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digirupt.services;

import com.digirupt.manager.BillManager;
import com.digirupt.util.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Partha
 */
public class GenerateBill extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            Map<String, String[]> jsonMap = request.getParameterMap();
            Map<String,String> finalMap=new HashMap();
//            String category = request.getParameter("category");
            String category = "basic";
            Set<String> keyList=jsonMap.keySet();
            for(String str:keyList){
            String[]arg=    jsonMap.get(str);
            String result=arg[0];
            finalMap.put(str, result);
            }
            

            String result = new BillManager().createBillIdBased(finalMap, category);

            if (result != null && !result.isEmpty()) {
                request.setAttribute("statuscode", Constants.HTTP_STATUS_SUCCESS);
                out.write(result);

            } else {
                request.setAttribute("statuscode", Constants.HTTP_STATUS_FAIL);
                out.write(Constants.HTTP_STATUS_FAIL);
            }
        } catch (Exception ex) {
            System.out.println("Exception::::" + ex);
            out.write(Constants.HTTP_STATUS_EXCEPTION + " Exception::::" + ex);

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
