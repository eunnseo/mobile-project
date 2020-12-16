<?php 

    error_reporting(E_ALL); 
    ini_set('display_errors',1); 

    include('dbcon.php');


    $android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");


    if( (($_SERVER['REQUEST_METHOD'] == 'POST') && isset($_POST['submit'])) || $android )
    {

        // 안드로이드 코드의 postParameters 변수에 적어준 이름을 가지고 값을 전달 받습니다.

        $name=$_POST['name'];
        $category=$_POST['category'];
        $donor=$_POST['donor'];
        $image1=$_POST['image1'];
        // $image2=$_POST['image2'];
        // $image3=$_POST['image3'];
        // $image4=$_POST['image4'];
        // $image5=$_POST['image5'];
        // $image6=$_POST['image6'];

        if(!isset($errMSG)) // 데이터가 모두 입력되면
        {
            try{
                // SQL문을 실행하여 데이터를 MySQL 서버의 donate 테이블에 저장합니다. 
                $stmt = $con->prepare('INSERT INTO donate(name, category, donor, image1) VALUES(:name, :category, :donor, :image1)');
                // $stmt = $con->prepare('INSERT INTO donate(name, category, image1, image2, image3, image4, image5, image6, donor) VALUES(:name, :category, :image1, :image2, :image3, :image4, :image5, :image6, :donor)');
                $stmt->bindParam(':name', $name);
                $stmt->bindParam(':category', $category);
                $stmt->bindParam(':donor', $donor);
                $stmt->bindParam(':image1', $image1);
                // $stmt->bindParam(':image2', $image2);
                // $stmt->bindParam(':image3', $image3);
                // $stmt->bindParam(':image4', $image4);
                // $stmt->bindParam(':image5', $image5);
                // $stmt->bindParam(':image6', $image6);

                if($stmt->execute())
                {
                    $successMSG = "새로운 데이터를 추가했습니다.";
                }
                else
                {
                    $errMSG = "데이터 추가 에러";
                }

            } catch(PDOException $e) {
                die("Database error: " . $e->getMessage()); 
            }
        }

    }

?>


<?php 
    if (isset($errMSG)) echo $errMSG;
    if (isset($successMSG)) echo $successMSG;

    $android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");
   
    if( !$android )
    {
?>
    <html>
       <body>

            <form action="<?php $_PHP_SELF ?>" method="POST">
                Name: <input type = "text" name = "name" />
                Country: <input type = "text" name = "country" />
                <input type = "submit" name = "submit" />
            </form>
       
       </body>
    </html>

<?php 
    }
?>