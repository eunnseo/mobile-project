<?php 

    error_reporting(E_ALL); 
    ini_set('display_errors',1); 

    include('dbcon.php');
        

    $stmt = $con->prepare('select donate.name, donate.category, donate.image1, donate.image2, donate.image3, product.price, product.store_loc from donate, product where donate.id = product.id');
    $stmt->execute();

    if ($stmt->rowCount() > 0)
    {
        $data = array(); 

        while($row=$stmt->fetch(PDO::FETCH_ASSOC))
        {
            extract($row);
    
            array_push($data, 
                array(
                'name'=>$name,
                'category'=>$category,
                'image1'=>$image1,
                'image2'=>$image2,
                'image3'=>$image3,
                'price'=>$price,
                'store_loc'=>$store_loc
            ));
        }

        header('Content-Type: application/json; charset=utf8');
        $json = json_encode(array("webnautes"=>$data), JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
        echo $json;
    }

?>