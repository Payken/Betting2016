/**
 * Created by fdarmoch on 2016-01-02.
 */

angular.module("AIpro").controller("adminCtrl", function($scope, $http){


    $scope.submitForm = function () {
        var target = document.getElementById('datetimepicker').value;
        $scope.object = {
           home : $scope.home,
           away : $scope.away,
           dateString : target,
           timeString : $scope.timeString,
           stack : $scope.stack,
           odd : $scope.odd,
            wallet: $scope.wallet

    }

//
//  //         var file = $scope.myFile;
//  //         var uploadUrl = 'admin/uploadPhoto';
//  //    console.log(JSON.toString($scope.myFile));
//  //    console.log(JSON.stringify($scope.myFile));
// //            uploadFileToUrl(file, uploadUrl);
////console.log("wyslalem");

        $http.post("admin/addBet", $scope.object)
            .then(function (response) {
                console.log(response.data);
                alert("odpowiedz");
            });

        //$http.post("admin/uploadPhoto", $scope.myFile).then(function (response) {
        //    console.log(response.data);
        //});
    }
        ///////////////////////////////////////////
    $scope.addManufacturer = function () {
        $scope.object = {
           name: $scope.nname,

        }

        console.log($scope.object.name);

        $http.post("admin/addManufacturer", $scope.object)
            .then(function(response)
            {
                console.log(response.data);
            });
    }
//    /////////////////////////////////////////////////
//
//    $scope.addPhoto = function () {
//        $scope.object = {
//            file: $scope.file,
//
//        formData : file.value
//
//        }
//
//        console.log($scope.object.file);
//
//        $http.post("/index/addPhoto", $scope.object)
//            .then(function(response)
//            {
//                console.log(response.data);
//            });
//    }
//
//
//
//    $scope.product = {
//        name: 'dupa'
//    };
//
//    $scope.upload = function (file) {
//        console.log("aaaa");
//        $scope.product.image = file;
//        Upload.upload({
//            url: '/index/dupa/uploadProduct',
//            data: $scope.product
//        }).then(function (resp) {
//            console.log('Success ' + resp.config.data.file.name + 'uploaded. Response: ' + resp.data);
//        }, function (resp) {
//            console.log('Error status: ' + resp.status);
//        });
//    };

});
