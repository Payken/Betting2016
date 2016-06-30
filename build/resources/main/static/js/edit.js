/**
 * Created by fdarmoch on 2016-01-02.
 */

angular.module("AIpro").controller("adminCtrl", function($scope, $http){


    $scope.bet = function () {
        var target = document.getElementById('id').value;
        var user = document.getElementById('user').value;

        $scope.object1 = {

            id: target,
           type : $scope.type,
            user: user,
            stack: $scope.stack

    }

        $http.post("edit/doIT", $scope.object1)
            .then(function (response) {
                console.log(response.data);
                alert(response.data);
            });

    }
//////////////////////////////////////////////////////////////////////////////////



});
