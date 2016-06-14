/**
 * Created by fdarmoch on 2016-01-02.
 */

angular.module("AIpro").controller("adminCtrl", function($scope, $http){


    $scope.won = function () {
        var target = document.getElementById('id').value;

        $scope.object = {

            id: target,
           homegoals : $scope.homegoals,
           awaygoals : $scope.awaygoals,
            won: "TRUE",
    }

        $http.post("edit/doIT", $scope.object)
            .then(function (response) {
                console.log(response.data);
                alert(response.data);
            });

    }
//////////////////////////////////////////////////////////////////////////////////

    $scope.lost = function () {
        var target = document.getElementById('id').value;
        $scope.object = {
            id: target,
            homegoals : $scope.homegoals,
            awaygoals : $scope.awaygoals,
            won: "FALSE",
        }


        $http.post("edit/doIT", $scope.object)
            .then(function (response) {
                console.log(response.data);
                alert(response.data);
            });

    }

});
