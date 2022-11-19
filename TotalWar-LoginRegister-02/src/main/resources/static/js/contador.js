  //Step 1 : Create a function to calculate time difference
  function diff(){
    var a = moment('2021-08-22 13:31:12') //past time
   var b = moment(); //current time
   diff = moment.preciseDiff(a, b, true); //object with years, months, days, hours, minutes, seconds


   // Loop through all of them and add 0 if less 10
   intervals = [{ingles:'months',español:'meses'}, {ingles:'days',español:'dias'}, {ingles:'hours',español:'horas'}, {ingles:'minutes',español:'minutos'}, {ingles:'seconds',español:'segundos'}];
   output = [];
   
   for(var i = 0; i < intervals.length; i++){
    var d = diff[intervals[i].ingles];
    var d = d < 10 ? '0' + d : d;
    output.push( d + '' + intervals[i].español);
   }

   //output the result in html
   console.log(output)
   document.getElementById("output").innerHTML = output.join(" ");
 }

 //step 2

setInterval(diff, 1000);