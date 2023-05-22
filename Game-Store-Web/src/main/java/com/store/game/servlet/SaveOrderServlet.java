package com.store.game.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.store.game.models.Payment;
import com.store.game.models.Product;
import com.store.game.models.User;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "SaveOrderServlet", urlPatterns = "/save-order")
public class SaveOrderServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String paymentType = request.getParameter("payType");
        List<Product> cartList = (List<Product>) request.getSession().getAttribute("final-cart-list");
        User currentUser = (User) request.getSession().getAttribute("loguser");
        String total = request.getParameter("total");
        Payment payment = new Payment(currentUser.getId(), UUID.randomUUID(), Double.parseDouble(total), dateFormat.format(date), paymentType, "Done", cartList.size(), cartList);

        try {
            HttpPost httpPost = new HttpPost(new URI("http://localhost:8081"));
            URI uri = new URIBuilder(httpPost.getURI())
                    .setPath("/game/store/" + paymentType + "/payement")
                    .build();
            httpPost.setURI(uri);
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(payment);

            StringEntity entity = new StringEntity(json, HTTP.UTF_8);
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-Type", "application/json");

            try (CloseableHttpClient httpClient = HttpClients.createDefault();
                 CloseableHttpResponse res = httpClient.execute(httpPost)) {
                HttpEntity ent = res.getEntity();
                if (ent != null) {
                    System.out.println(EntityUtils.toString(ent));
                    request.getSession().removeAttribute("final-cart-list");
                    request.getSession().removeAttribute("cart-list");
                    response.sendRedirect("order.jsp");
                }

            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

}
