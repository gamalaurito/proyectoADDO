<!--header-->
<div class="header-top">
    <div class="header-bottom">
        <div class="container">
            <div class="logo">
                <a href="index.jsp"><h1>Floreria Jamaica</h1></a>
            </div>
            <div class="top-nav" id = "divMenu">
            </div>
            <div class="cart box_1">
                <a href="checkout.jsp">
                    <h3>
                        <div class="total">
                            <!--
                            <span class="simpleCart_total"></span>
                            -->
                            <span id = "totalC">
                                <%int totalP = 0;%>
                                <%if(session.getAttribute("totalC")!=null) {%>
                                <%totalP = (Integer)session.getAttribute("totalP");%>
                                <%=(String)session.getAttribute("totalC")%>
                                <%} else {%>
                                    0.00
                                <%}%>
                            </span>
                            (<span id="totalP"><%=totalP%></span>)
                        </div>
                        <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
                    </h3>
                </a>
                <p onclick = "vaciarCarrito()"><a>Vaciar Carrito</a></p>
                <div class="clearfix"> </div>
            </div>
            <div class="clearfix"> </div>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<script>
    getMenu();
</script>