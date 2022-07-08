<%-- 
    Document   : Checkout
    Created on : Jul 9, 2022, 12:01:53 AM
    Author     : 84384
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta http-equiv="x-ua-compatible" content="ie=edge" />
        <title>Material Design for Bootstrap</title>
        <!-- MDB icon -->
        <link rel="icon" href="img/mdb-favicon.ico" type="image/x-icon" />
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" />
        <!-- Google Fonts Roboto -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" />
        <!-- MDB -->
        <link rel="stylesheet" href="css/mdb.min.css" />
    </head>

    <body>
        <!-- Credit card form -->
        <section>
            <div class="row">
                <div class="col-md-8 mb-4">
                    <div class="card mb-4">
                        <div class="card-header py-3">
                            <h5 class="mb-0">Biling details</h5>
                        </div>
                        <div class="card-body">
                            <form>
                                <!-- 2 column grid layout with text inputs for the first and last names -->
                                <div class="row mb-4">
                                    <div class="col">
                                        <div class="form-outline">
                                            <input type="text" id="form6Example1" class="form-control" />
                                            <label class="form-label" for="form6Example1">First name</label>
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="form-outline">
                                            <input type="text" id="form6Example2" class="form-control" />
                                            <label class="form-label" for="form6Example2">Last name</label>
                                        </div>
                                    </div>
                                </div>

                                <!-- Text input -->
                                <div class="form-outline mb-4">
                                    <input type="text" id="form6Example3" class="form-control" />
                                    <label class="form-label" for="form6Example3">Company name</label>
                                </div>

                                <!-- Text input -->
                                <div class="form-outline mb-4">
                                    <input type="text" id="form6Example4" class="form-control" />
                                    <label class="form-label" for="form6Example4">Address</label>
                                </div>

                                <!-- Email input -->
                                <div class="form-outline mb-4">
                                    <input type="email" id="form6Example5" class="form-control" />
                                    <label class="form-label" for="form6Example5">Email</label>
                                </div>

                                <!-- Number input -->
                                <div class="form-outline mb-4">
                                    <input type="number" id="form6Example6" class="form-control" />
                                    <label class="form-label" for="form6Example6">Phone</label>
                                </div>

                                <hr class="my-4" />

                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="checkoutForm1" />
                                    <label class="form-check-label" for="checkoutForm1">
                                        Shipping address is the same as my billing address
                                    </label>
                                </div>

                                <div class="form-check mb-4">
                                    <input class="form-check-input" type="checkbox" value="" id="checkoutForm2" checked />
                                    <label class="form-check-label" for="checkoutForm2">
                                        Save this information for next time
                                    </label>
                                </div>

                                <hr class="my-4" />

                                <h5 class="mb-4">Payment</h5>

                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="checkoutForm3" checked />
                                    <label class="form-check-label" for="checkoutForm3">
                                        Credit card
                                    </label>
                                </div>

                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="checkoutForm4" />
                                    <label class="form-check-label" for="checkoutForm4">
                                        Debit card
                                    </label>
                                </div>

                                <div class="form-check mb-4">
                                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="checkoutForm5" />
                                    <label class="form-check-label" for="checkoutForm5">
                                        Paypal
                                    </label>
                                </div>

                                <div class="row mb-4">
                                    <div class="col">
                                        <div class="form-outline">
                                            <input type="text" id="formNameOnCard" class="form-control" />
                                            <label class="form-label" for="formNameOnCard">Name on card</label>
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="form-outline">
                                            <input type="text" id="formCardNumber" class="form-control" />
                                            <label class="form-label" for="formCardNumber">Credit card number</label>
                                        </div>
                                    </div>
                                </div>

                                <div class="row mb-4">
                                    <div class="col-3">
                                        <div class="form-outline">
                                            <input type="text" id="formExpiration" class="form-control" />
                                            <label class="form-label" for="formExpiration">Expiration</label>
                                        </div>
                                    </div>
                                    <div class="col-3">
                                        <div class="form-outline">
                                            <input type="text" id="formCVV" class="form-control" />
                                            <label class="form-label" for="formCVV">CVV</label>
                                        </div>
                                    </div>
                                </div>

                                <button class="btn btn-primary btn-lg btn-block" type="submit">
                                    Continue to checkout
                                </button>
                            </form>
                        </div>
                    </div>
                </div>

                <div class="col-md-4 mb-4">
                    <div class="card mb-4">
                        <div class="card-header py-3">
                            <h5 class="mb-0">Summary</h5>
                        </div>
                        <div class="card-body">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                                    Products
                                    <span>$53.98</span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center px-0">
                                    Shipping
                                    <span>Gratis</span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
                                    <div>
                                        <strong>Total amount</strong>
                                        <strong>
                                            <p class="mb-0">(including VAT)</p>
                                        </strong>
                                    </div>
                                    <span><strong>$53.98</strong></span>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Credit card form -->

        <!-- MDB -->
        <script type="text/javascript" src="js/mdb.min.js"></script>
        <!-- Custom scripts -->
        <script type="text/javascript"></script>
    </body>

</html>
