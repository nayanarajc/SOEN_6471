    <script>
                function myFunction_hide() {
                  var x = document.getElementById("ret_date");
                  var y = document.getElementById("ret_label");
                  x.disabled = "disabled";
                  y.disabled = "disabled";
                }
              </script>
              <script>
                function myFunction_show() {
                  var x = document.getElementById("ret_date");
                  var y = document.getElementById("ret_label");
                  x.removeAttribute("disabled");
                  y.removeAttribute("disabled");
                }
              </script>
              <script>
                function bookTicket() {
				$("#booking").show();
                  $('html, body').animate({
                    scrollTop: $("#booking").offset().top
                  }, 1000);
                }
                function AddData() {
				  
                  var trip;
                  var from = document.getElementById('from_id').value;
                  var to = document.getElementById('return_id').value;
                  var rows = "";
                  if (document.getElementById('roundtrip').checked) {
                    trip = document.getElementById('roundtrip').value;
                  }

                  if (document.getElementById('one-way').checked) {
                    trip = document.getElementById('one-way').value;
                  }

                  var row1 = "<td>British Airways</td><td>22h 13m</td><td>957</td><td>2</td>";
                  var row2 = "<td>Air Canada</td><td>19h 45m</td><td>1076</td><td>3</td>";
                  var row3 = "<td>Lufthansa</td><td>27h 39m</td><td>1854</td><td>1</td>"
                  var row4 = "<td>British Airways</td><td>23h 30m</td><td>851</td><td>1</td>"
                  var row5 = "<td>Air Canada</td><td>21h 22m</td><td>1230</td><td>1</td>"
                  var row6 = "<td>Lufthansa</td><td>25h 55m</td><td>1009</td><td>1</td>"

                  var button = "<td><div><button type='submit' onclick='bookTicket()' class='btn btn-primary'>Book</button></div></td>";
                  var buttonRound = "<td rowspan='2'><div><button type='submit' onclick='bookTicket()' class='btn btn-primary'>Book</button></div></td>";

                  if (trip == "roundtrip") {
                    //generate data tables realted to round trip
                    $("#tbRound").show();
                    $("#tbDetails").hide();
                    //$("#tbDetails").css("display","block");
                    $("#tbRound td").remove();
                    rows += "<tr><td>" + from + "</td><td>" + to + "</td>" + row1 + button + "</tr> ";
                    rows += "<tr><td>" + to + "</td><td>" + from + "</td>" + row4 + "</tr> ";
                    rows += "<tr><td>" + from + "</td><td>" + to + "</td>" + row2 + button + "</tr> ";
                    rows += "<tr><td>" + to + "</td><td>" + from + "</td>" + row5 + "</tr> ";
                    rows += "<tr><td>" + from + "</td><td>" + to + "</td>" + row3 + button + " </tr> ";
                    rows += "<tr><td>" + to + "</td><td>" + from + "</td>" + row6 + "</tr> ";

                    $(rows).appendTo("#tbRound tbody");
                  }
                  else {
                    $("#tbDetails").show();
                    $("#tbRound").hide();
                    //$("#tbDetails").css("display","block");
                    $("#tbDetails td").remove();
                    rows += "<tr><td>" + from + "</td><td>" + to + "</td>" + row1 + button + "</tr> ";
                    rows += "<tr><td>" + from + "</td><td>" + to + "</td>" + row2 + button + "</tr> ";
                    rows += "<tr><td>" + from + "</td><td>" + to + "</td>" + row3 + button + " </tr> ";

                    $(rows).appendTo("#tbDetails tbody");
                    //generate data table realted to one-way trip
                  }
                  return false;
                }
              </script>

              <script>

                $(document).ready(function () {
				$("#booking").hide();
				$("#payment").hide();
                  $(".error1").hide();
                  $(".error2").hide();
                  $(".error3").hide();
                  $(".error4").hide();
                  $(".error5").hide();
                  $(".error6").hide();
                  $(".error7").hide();
                  $(".error8").hide();
                  $(".error9").hide();
                  $(".error10").hide();
                  $(".error11").hide();
                  $(".error12").hide();

                  $("h2").addClass("blue");

                  $('#searchFlight').submit(function (e) {
                    e.preventDefault();
                    var from = $('#from_id').val();
                    var to = $('#return_id').val();
                    var dept_date = $('#dept_date').val();
                    var return_date = $('#ret_date').val();

                    if (!$('#roundtrip').is(':checked') && !$('#one-way').is(':checked')) {
                      //$("<div>Test message</div>").dialog();
                      alert('Please select one(round trip or one way)');
                      $("#tbRound").hide();
                      $("#tbDetails").hide();
                    }

                    else if (from == "") {
                      alert('Please fill flying from field');
                      $("#tbRound").hide();
                      $("#tbDetails").hide();
                    }

                    else if (to == "") {
                      alert('Please fill flying to field');
                      $("#tbRound").hide();
                      $("#tbDetails").hide();
                    }

                    else if (from == to) {
                      alert('Source and destination cannot be same');
                      $("#tbRound").hide();
                      $("#tbDetails").hide();
                    }

                    else if (new Date(dept_date) > new Date(return_date)) {
                      alert('Departure date cannot be later than return date');
                      $("#tbRound").hide();
                      $("#tbDetails").hide();
                    }
                    // else {
                    //   $("#tbRound").show();
                    //   $("#tbDetails").show();
                    // }

                  });

                  $('#form1').submit(function (e) {
				  $("#payment").show();
                    e.preventDefault();
                    var first_name = $('#name').val();
                    var contact = $('#contact').val();
                    var email = $('#email').val();
                    var addr = $('#addr').val();
                    var postal = $('#post').val();
                    var city = $('#city').val();
                    var country = $('#country').val();


                    if (first_name.length < 1) {
                      $(".error1").show();
                    }
                    else {
                      $(".error1").hide();
                    }

                    if (email.length < 1) {
                      $('.error2').show();
                    } else if (email.length >= 1) {
                      var regEx = /^[a-zA-Z0-9][a-zA-Z0-9._%+-]{0,63}@(?:[a-zA-Z0-9-]{1,63}\.){1,125}[a-zA-Z]{2,63}$/;
                      var validEmail = regEx.test(email);
                      if (!validEmail) {
                        $('.error2').show();
                      }
                      else {
                        $(".error2").hide();
                      }
                    }

                    if (contact.length < 1) {
                      $(".error3").show();
                    }
                    else {
                      $(".error3").hide();
                    }

                    if (addr.length < 1) {
                      $(".error4").show();
                    }
                    else {
                      $(".error4").hide();
                    }

                    if (postal.length < 1) {
                      $(".error7").show();
                    }
                    else {
                      $(".error7").hide();
                    }

                    if (city.length < 1) {
                      $(".error5").show();
                    }
                    else {
                      $(".error5").hide();
                    }

                    if (country.length < 1) {
                      $(".error6").show();
                    }
                    else {
                      $('html, body').animate({
                        scrollTop: $("#payment").offset().top
                      }, 1000);
                      $(".error6").hide();
                    }
                  });
                  $('#form_payment').submit(function (e) {
                    e.preventDefault();
                    var name_card = $('#name_c').val();
                    var card_num = $('#card').val();
                    var e_month = $('#month').val();
                    var e_year = $('#year').val();
                    var cvv = $('#cvv').val();
                    if (name_card.length < 1) {
                      $('.error8').show();
                    }

                    else {
                      $(".error8").hide();
                    }


                    if (card_num.length < 1) {
                      $(".error9").show();
                    }

                    else if (card_num.length >= 1) {
                      var regEx = /^[0-9]{16}$/;
                      var validCard = regEx.test(card_num);
                      if (!validCard) {
                        $('.error9').show();
                      }
                      else {
                        $(".error9").hide();
                      }
                    }

                    if (e_month.length < 1 || (e_month < 1 || e_month > 12)) {
                      $(".error10").show();
                    }
                    else if (e_month.length >= 1) {
                      var regEx = /^[0-9]{2}$/;
                      var validMonth = regEx.test(e_month);
                      if (!validMonth) {
                        $('.error10').show();
                      }
                      else {
                        $(".error10").hide();
                      }
                    }
                    if (e_year.length < 1 || (e_year < 2019 || e_year > 2100)) {
                      $(".error11").show();
                    }
                    else if (e_year.length >= 1) {
                      var regEx = /^[0-9]{4}$/;
                      var validYear = regEx.test(e_year);
                      if (!validYear) {
                        $('.error11').show();
                      }
                      else {
                        $(".error11").hide();
                      }
                    }

                    if (cvv.length < 1) {
                      $(".error12").show();
                    }
                    else if (cvv.length >= 1) {
                      var regEx = /^[0-9]{3}$/;
                      var validCVV = regEx.test(cvv);
                      if (!validCVV) {
                        $('.error12').show();
                      }
                      else {
                        $(".error12").hide();
                      }
                    }
                  });

                });
              </script>
