<?php
$con = mysqli_connect("localhost", "root", "", "foodie_register");
if(!$con)
{
echo"error".mysqli_connect_error();
}
else
{
echo"success";
}
?>
    