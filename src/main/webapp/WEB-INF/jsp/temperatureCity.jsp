<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Weather App</title>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <style type="text/css">
            body {
                font-family: arial; 
                font-size: 0.8em;
            }
            fieldset {
                width: 900px;
            }
            fieldset ul, fieldset li{
                border:0; margin:0; padding:10px 10px 10px 10px; list-style:none;
            }
            fieldset li{
                clear:both;
                padding-bottom:10px;
            }
            fieldset li #error_span {
                padding-left:140px;
                color: red;
            }
           
            #weather_showtable {
                width:800px;
            }
            #weather_showtable tr td {
                padding:10px 10px 10px 10px;
                text-align: center;
            }
            #reset {
                color: red;
            }
        </style>

    </head>
    <body>
        <form name="weather_form" action="weather" method="post">
            <fieldset>
                <legend><b>Temperature</b></legend>
                <ul>
                    <li> 
                       <button type="submit" id="send" name="send">Get Temperature</button> 
                        <div>&nbsp;&nbsp;
                        </div>
                          <div id="countries">
                            Countries : &nbsp;&nbsp;&nbsp;&nbsp;
                        <select onchange="getCities()" id="country">
						  <option value="-1">--select--</option>
						  <option value="India">India</option>
						  <option value="Ukraine">Ukraine</option>
						  <option value="US">US</option>
						  <option value="United Kingdom">United Kingdom</option>
						  <option value="Nepal">Nepal</option>
						  <option value="Germany">Germany</option>
						  <option value="Japan">Japan</option>
						 </select>
						 </div>
						 <div>&nbsp;&nbsp;
                        </div>
                        <div id="cities">
						  Cities : <select onChange="getTemp(this)"
						   id="city"> 
						   <option value="-1">--select--</option>
						  </select>
						    <button type="submit" id="send" name="send" onClick="getweatherByCityName()" >Temperature for selected city</button> 
						 </div>
						
                    </li>
                    <li> 
                        <span id="error_span" name="error_span"></span>
                    </li>                    
                </ul>
            </fieldset>
            <br>
           
            <div style="display:none;" id="weathercity_showtable_div">
            <table id="weathercity_showtable" cellpadding=6  frame=box  >
                <thead>
                    <tr > 
                        <th>Temperature (F)</th> 
                        <th>Wind Speed (KMPH)</th> 
                        <th>Visibility</th> 
                        <th>Humidity</th> 
                    </tr>
					
                </thead>
               
                <tbody id="temperaturecitytbody">
                </tbody>
            </table>
            </div>
          <div>
          &nbsp;
          </div> <div>
          &nbsp;
          </div>
          <div style="display:none;" id="month_weather_showtable_div">
             <table id="month_weather_showtable" cellpadding=6 rules=groups  frame=box>
                <thead>
                   <tr>
                        <th>Month</th> 
                        <th>Min Avg Temp(F)</th> 
                        <th>Max Abs Temp(F)</th> 
                    </tr>
                </thead>
                <tbody id="temperatureMonthtbody">
                </tbody>
            </table>
            </div>
        </form>
        <script type="text/javascript">
            $('form').submit(function(event) {
              event.preventDefault();
              var zip = $('#zip').val();
              if(zip=='' ){
          	   
          		}
          	else {
              $.ajax({
                  type: "POST",
                  url: $('#weather_form').attr('action'),
                  dataType: "json",
                  data: {zip: zip},
                  success: function(data) {
                    $("#error_span").html("");                      
                    populateTable(data);
                  },
                  error: function(e) {
                    $("#temperaturetbody").html("");
                    $("#temperatureMonthtbody").html("");
                    $("#error_span").html(e.responseText);
                  }
              });
            }
            });
            
            function populateTable(temperature) {
            	
				for (var i in temperature.monthsClimateAverage) {
						if(i==0){
							 monthData =  
							"<tr>"+
		                	"<td>"+temperature.monthsClimateAverage[i].name+  "</td>" + 
		                	"<td>"+temperature.monthsClimateAverage[i].minAvgTempF+  "</td>" +
		                	"<td>"+temperature.monthsClimateAverage[i].maxAbsAvgTempF+  "</td>" +
		                	"</tr>" ;
						}else{
							 monthData =  monthData +
							"<tr>"+
		                	"<td>"+temperature.monthsClimateAverage[i].name+  "</td>" + 
		                	"<td>"+temperature.monthsClimateAverage[i].minAvgTempF+  "</td>" +
		                	"<td>"+temperature.monthsClimateAverage[i].maxAbsAvgTempF+  "</td>" +
		                	"</tr>" ;
						}
				}
                var row = "<tr> \
                            <td>"+temperature.city+"</td> \
                            <td>"+temperature.state+"</td> \
                            <td>"+temperature.country+"</td> \
                            <td>"+temperature.localTime+"</td> \
                            <td>"+temperature.temperature+"</td> \
                            <td>"+temperature.latitude+"</td> \
                            <td>"+temperature.longitude+"</td> \
                            <td>"+temperature.elevation+"</td> \
                            <td>"+temperature.windMph+"</td> \
                            <td>"+temperature.uv+"</td> \
                            <td>" 
							+
                            "</td> \
                           </tr>";    
                document.getElementById("weather_showtable_div").style.display = 'block';	
				document.getElementById("month_weather_showtable_div").style.display = 'block';		
				document.getElementById("weather_showtable").style.display = 'none';	
                $("#temperaturetbody").html(row);
                $("#temperatureMonthtbody").html(monthData);
            }
            
	function populateTableForWeatherByCity(responsetxt) {
				var temperatureobj = JSON.parse(responsetxt);
				 var row = "<tr> \
		             <td>"+temperatureobj.temperature+"</td> \
		             <td>"+temperatureobj.windSpeedKmph+"</td> \
		             <td>"+temperatureobj.visibility+"</td> \
		             <td>"+temperatureobj.humidity+"</td> \
		             <td>" 
						+
		             "</td> \
		            </tr>";    
				
			    
			    
				for (var i=0;i<12;i++) {
						if(i==0){
							 monthData =  
							"<tr>"+
		                	"<td>"+temperatureobj.monthsClimateAverage[i].name+  "</td>" + 
		                	"<td>"+temperatureobj.monthsClimateAverage[i].minAvgTempF+  "</td>" +
		                	"<td>"+temperatureobj.monthsClimateAverage[i].maxAbsAvgTempF+  "</td>" +
		                	"</tr>" ;
						}else{
							 monthData =  monthData +
							"<tr>"+
		                	"<td>"+temperatureobj.monthsClimateAverage[i].name+  "</td>" + 
		                	"<td>"+temperatureobj.monthsClimateAverage[i].minAvgTempF+  "</td>" +
		                	"<td>"+temperatureobj.monthsClimateAverage[i].maxAbsAvgTempF+  "</td>" +
		                	"</tr>" ;
						}
				}
				 document.getElementById("weather_showtable").style.display = 'none';	
				 document.getElementById("weathercity_showtable_div").style.display = 'block';	
				 document.getElementById("temperatureMonthtbody").innerHTML = monthData;
				 
				 $("#temperaturecitytbody").html(row);
				 $("#temperatureMonthtbody").html(monthData);
               
                
                
            }
            function getweatherByCityName() {
                var selectOb = document.getElementById("city");
                var city = selectOb.options[selectOb.selectedIndex].value;
                if (city == "-1") {
                       alert("Invalid selection");
                       return false;
		                }
                
		           var xmlHttp;
		           xmlHttp = new XMLHttpRequest();
		           var url = "\weatherbyCity";
		           url += "?city=" + city;
		           xmlHttp.onreadystatechange = function() {
		           if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {
		        	   var responsetext = xmlHttp.responseText;
		        	   populateTableForWeatherByCity(responsetext);
		        	    
		            }
		
		           };
		           xmlHttp.open("POST", url, true);
		           xmlHttp.send(null);

          		}
            
            
            function getCities() {
                var selectOb = document.getElementById("country");
                var country = selectOb.options[selectOb.selectedIndex].value;
                if (country == "-1") {
                       alert("Invalid selection");
                       return false;
		                }
                
		           var xmlHttp;
		           xmlHttp = new XMLHttpRequest();
		           var url = "\getcities";
		           url += "?country=" + country;
		           xmlHttp.onreadystatechange = function() {
		           if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {
		        	   var responsetext = xmlHttp.responseText;
		        	   var responxml = xmlHttp.responseXML;
		        	   
		        	   var array = responsetext.split(',');
		        	   // document.getElementById("cities").innerHTML = xmlHttp.responseText  
		        	    var sel = document.getElementById('city');
		        	    for(var i = 0; i < array.length; i++) {
		        	        var opt = document.createElement('option');
		        	        var stripped = array[i].replace(/[^A-Za-z0-9]/g, '');
		        	        //var replacedArray = array[i].replace(/\W/g, '');
		        	        opt.innerHTML = stripped;
		        	        opt.value =stripped;
		        	        sel.appendChild(opt);
		        	    }
		        	    
		            }
		
		           };
		           xmlHttp.open("GET", url, true);
		           xmlHttp.send(null);

          		}
            
          
            function myFunction(xml) {
          	  var x, i, xmlDoc, txt;
          	  xmlDoc = xml.responseXML;
          	  txt = "";
          	  x = xmlDoc.getElementsByTagName("City");
          	  for (i = 0; i< x.length; i++) {
          	    txt += x[i].childNodes[0].nodeValue + "<br>";
          	  }
          	  document.getElementById("cities").innerHTML = txt;
          	}
          
                function getTemp(x) {

                    var selectOb = document.getElementById("country");
                    var country = selectOb.options[selectOb.selectedIndex].value;
                    if (country == "-1" || x == "select") {
                    alert("Invalid selection");
                    return false;
			         }
			         var xmlHttp;
			         xmlHttp = new XMLHttpRequest();
			         var url = "\getcities";
			         url += "?country=" + country + "&city=" + x;
			         xmlHttp.onreadystatechange = function() {
			                   if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {
			                   document.getElementById("weather").innerHTML = xmlHttp.responseText
			         }
			
			         };
			         xmlHttp.open("GET", url, true);
			         xmlHttp.send(null);
			
			        }
        </script>
    </body>
</html>
