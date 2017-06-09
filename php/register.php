<?php
    $con = mysqli_connect("localhost", "root", "", "foodie_register");
    
    $username = $_POST["username"];
    $phone = $_POST["phone"];
    $location =$_POST["location"];
    $password = $_POST["password"];
    $query="insert into register values('$username','$phone','$location','$password');";
   

 if(mysqli_query($con,$query))
{
//echo"<h3> success</h3>";
}
else
{
//echo"failed".mysqli_error($con);
}
?>