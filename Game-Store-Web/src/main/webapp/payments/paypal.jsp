<%--
  Created by IntelliJ IDEA.
  User: dtsangeeth
  Date: 5/23/23
  Time: 00:40
  To change this template use File | Settings | File Templates.
--%>
<div>
  <div class="card-body border p-0">
    <p>
      <a class="btn btn-primary p-2 w-100 h-100 d-flex align-items-center justify-content-between"
         data-bs-toggle="collapse" href="#collapseExample" role="button" aria-expanded="true"
         aria-controls="collapseExample">
        <span class="fw-bold">PayPal</span>
        <span class="">
            <span class="fab fa-cc-paypal"></span>
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
            <img src="https://www.paypalobjects.com/digitalassets/c/website/logo/full-text/pp_fc_hl.svg" alt="">
          </div>
        </div>
        <div class="col-lg-7">
          <div class="col-12">
            <form action="save-order" method="post">
              <input type="hidden" id="payType" name="payType" value="paypal">
              <input type="hidden" id="total" name="total" value=<%= total %>>
              <button type="submit" class="btn btn-primary w-100">Sumbit</button>
            </form>
          </div>
        </div>
      </div>
      </div>
  </div>
</div>