/**

 * Created by fdarmoch on 2016-01-02.
 */

angular.module("AIpro").controller("searchCtrl", function($scope, $http){


    $scope.searchBet = function () {
        $scope.object = {

            walletid: $scope.walletid,
            active: $scope.active,

        }


        $http.post("search/searchBet", $scope.object)
            .then(function (response) {
                console.log(response.data);
            $scope.response=response.data;

            });

    }

    $scope.getTotalBid = function(){

        var total = 0;
        for(var i = 0; i < $scope.response.length; i++){
            var product = $scope.response[i];
            //total += (product.price * product.quantity);
            total+=product.bid;
        }
        return total;
    }
    $scope.getTotalReturn = function(){

        var total = 0;
        for(var i = 0; i < $scope.response.length; i++){
            var product = $scope.response[i];
            //total += (product.price * product.quantity);
            if(product.won!=false)
            total+=product.bid*product.odd;
        }
        return total;
    }


});
