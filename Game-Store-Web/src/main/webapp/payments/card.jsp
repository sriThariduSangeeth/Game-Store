<%@ page import="com.store.game.models.User" %>
<%--
  Created by IntelliJ IDEA.
  User: dtsangeeth
  Date: 5/23/23
  Time: 00:15
  To change this template use File | Settings | File Templates.
--%>
<%
  if(user == null){
    out.println("No user");
  }
%>
<div>
  <div class="card-body border p-0">
    <p>
      <a class="btn btn-primary p-2 w-100 h-100 d-flex align-items-center justify-content-between"
         data-bs-toggle="collapse" href="#collapseExample" role="button" aria-expanded="true"
         aria-controls="collapseExample">
        <span class="fw-bold">Credit Card</span>
        <span class="">
                                <span class="fab fa-cc-amex"></span>
                                <span class="fab fa-cc-mastercard"></span>
                                <span class="fab fa-cc-discover"></span>
                            </span>
      </a>
    </p>
    <div class="collapse show p-3 pt-0" id="collapseExample">
      <div class="row">
        <div class="col-lg-5 mb-lg-0 mb-3">
          <p class="h4 mb-0"><%= user.getFname() %> <%= user.getLname() %></p>
          <p class="mb-0">
            <span class="fw-bold">Total Amount:</span>
            <span class="c-green"><%= total %></span>
          </p>
          <br><br>
          <div class="img-box">
            <img src="https://www.freepnglogos.com/uploads/visa-logo-download-png-21.png" alt="">
          </div>
        </div>
        <div class="col-lg-7">
          <form action="save-order" method="post">
            <div class="row">
              <div class="col-12">
                <div class="form__div">
                  <input type="text" class="form-control" placeholder=" ">
                  <label class="form__label">Card Number</label>
                </div>
              </div>

              <div class="col-6">
                <div class="form__div">
                  <input type="text" class="form-control" placeholder=" ">
                  <label class="form__label">MM / yy</label>
                </div>
              </div>

              <div class="col-6">
                <div class="form__div">
                  <input type="password" class="form-control" placeholder=" ">
                  <label class="form__label">cvv code</label>
                </div>
              </div>
              <div class="col-12">
                <div class="form__div">
                  <input type="text" class="form-control" placeholder=" ">
                  <label class="form__label">name on the card</label>
                </div>
              </div>
              <div class="col-12">

                  <input type="hidden" id="payType" name="payType" value="card">
                  <input type="hidden" id="total" name="total" value=<%= total %>>
                  <button type="submit" class="btn btn-primary w-100">Sumbit</button>

              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>

</div>
