<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Copyright (c) Betsey McCarthy, Mitchell Thompson
-->
<html>
    <head>
        <title>Investment Result</title>
        <meta charset="UTF-8">
         <link rel="stylesheet" href="styles/styles.css" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
      <h1>Future Value Calculator</h1>
      <form action="calculate" method="post">
        <input type="hidden" name="action" value="calculate">        
        <label class="resultLabels">Investment Amount: </label>
        <label class="results">${investment}</label><br>
        <label class="resultLabels">Yearly Interest Rate: </label>
        <label class="results">${rate}</label><br>
        <label class="resultLabels">Number of Years: </label>
        <label class="results">${years}</label><br>
        <label class="resultLabels">Future Value: </label>
        <label class="results" id="futureValue"> ${result}</label>
        <label>&nbsp;</label>
      </form>
      <footer>
        Copyright &copy; 2015 by Mitch Thompson and Betsey McCarthy     
      </footer>
    </body>
</html>
