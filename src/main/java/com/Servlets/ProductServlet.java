package com.Servlets;

import com.Product.Box;
import com.Product.Boxes;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Boxes productDao;

    public void init() {
        productDao = new Boxes();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Boxes.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        Unmarshaller unmarshaller = null;
        try {
            unmarshaller = context.createUnmarshaller();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        try {
            Boxes products = (Boxes) unmarshaller.unmarshal(new FileReader("src/main/java/com/Product/Boxes.xml"));
            request.setAttribute("products", products);
            request.getRequestDispatcher("src/main/webapp/index.jsp").forward(request, response);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String action = request.getParameter("action");
//
//        if ("add".equals(action)) {
//            addProduct(request);
//        } else if ("update".equals(action)) {
//            updateProduct(request);
//        } else if ("delete".equals(action)) {
//            deleteProduct(request);
//        }
//
//        response.sendRedirect(request.getContextPath() + "/products");
//    }

//    private void addProduct(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String description = request.getParameter("description");
//
//        Product product = new Product(name, description);
//        productDao.addProduct(product);
//    }
//
//    private void updateProduct(HttpServletRequest request) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String description = request.getParameter("description");
//
//        Product updatedProduct = new Product(name, description);
//        updatedProduct.setId(id);
//
//        productDao.updateProduct(updatedProduct);
//    }
//
//    private void deleteProduct(HttpServletRequest request) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        productDao.deleteProduct(id);
//    }
}