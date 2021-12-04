
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.bookshop.shopping.CartProduct"%>
<%@page import="com.bookshop.shopping.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Tạo mới đơn hàng</title>
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- Custom styles for this template -->
        <link href="https://pay.vnpay.vn/lib/vnpay/vnpay.css" rel="stylesheet" />
    </head>

    <body>
        <div class="container">
            <div class="header clearfix">

                <h3 class="text-muted">VNPAY DEMO</h3>
            </div>
            <h3>Tạo mới đơn hàng</h3>
            <div class="table-responsive">
                <%
                    Cart cart = (Cart)session.getAttribute("CART");
                    
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
                    LocalDateTime now = LocalDateTime.now();
                    String order_time = dtf.format(now);
                    
                    int totalMoney = 0;
                    
                    if (cart != null) {
                        
                    for (CartProduct product : cart.getCart().values()) {
                        totalMoney += product.getPrice()* product.getQuantity();
                    }
                    
                %>
                <form action="/BookShop/vnpayajax" id="frmCreateOrder" method="post">        
                    <div class="form-group">
                        <label for="language">Loại hàng hóa </label>
                        <select name="ordertype" id="ordertype" class="form-control">
                            <option value="topup">Mua sách</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="amount"></label>
                        <input class="form-control" data-val="true" data-val-number="The field Amount must be a number." data-val-required="The Amount field is required." id="amount" name="amount" type="number" value="<%= totalMoney %>" readonly=""/>
                    </div>
                    <div class="form-group">
                        <label for="OrderDescription">Nội dung thanh toán</label>
                        <textarea class="form-control" cols="20" id="vnp_OrderInfo" name="vnp_OrderInfo" rows="2" readonly="">Thanh toan don hang thoi gian <%= order_time %></textarea>
                    </div>
                    <div class="form-group">
                        <label for="bankcode">Ngân hàng</label>
                        <select name="bankcode" id="bankcode" class="form-control">
                            <option value="">Không chọn </option>
                            <option value="NCB">  	Ngân hàng NCB</option>
<!--                            <option value="SACOMBANK">Ngan hang SacomBank  </option>
                            <option value="EXIMBANK"> 	Ngan hang EximBank </option>
                            <option value="MSBANK"> 	Ngan hang MSBANK </option>
                            <option value="NAMABANK"> 	Ngan hang NamABank </option>
                            <option value="VISA">  	Thanh toan qua VISA/MASTER</option>
                            <option value="VNMART">  	Vi dien tu VnMart</option>
                            <option value="VIETINBANK">Ngan hang Vietinbank  </option>
                            <option value="VIETCOMBANK"> 	Ngan hang VCB </option>
                            <option value="HDBANK">Ngan hang HDBank</option>
                            <option value="DONGABANK">  	Ngan hang Dong A</option>
                            <option value="TPBANK"> 	Ngân hàng TPBank </option>
                            <option value="OJB">  	Ngân hàng OceanBank</option>
                            <option value="BIDV"> Ngân hàng BIDV </option>
                            <option value="TECHCOMBANK"> 	Ngân hàng Techcombank </option>
                            <option value="VPBANK"> 	Ngan hang VPBank </option>
                            <option value="AGRIBANK"> 	Ngan hang Agribank </option>
                            <option value="MBBANK"> 	Ngan hang MBBank </option>
                            <option value="ACB"> Ngan hang ACB </option>
                            <option value="OCB"> Ngan hang OCB </option>-->
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="language">Ngôn ngữ</label>
                        <select name="language" id="language" class="form-control">
                            <option value="vn">Tiếng Việt</option>
                            <option value="en">English</option>
                        </select>
                    </div>
                    <%
                        }
                    %>
                    <button type="submit" class="btn btn-success mt-2">Thanh toán</button>
                </form>
            </div>
            <p>
                &nbsp;
            </p>
            <footer class="footer">
                <p>&copy; VNPAY 2015</p>
            </footer>
        </div>  
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="https://pay.vnpay.vn/lib/vnpay/vnpay.min.js"></script>
        
        <script type="text/javascript">
            $("#frmCreateOrder").submit(function () {
                var postData = $("#frmCreateOrder").serialize();
                var submitUrl = $("#frmCreateOrder").attr("action");
                $.ajax({
                    type: "POST",
                    url: submitUrl,
                    data: postData,
                    dataType: 'JSON',
                    success: function (x) {
                        if (x.code === '00') {
                            if (window.vnpay) {
                                vnpay.open({width: 768, height: 600, url: x.data});
                            } else {
                                location.href = x.data;
                            }
                            return false;
                        } else {
                            alert(x.Message);
                        }
                    }
                });
                return false;
            });
        </script>       
    </body>
</html>
