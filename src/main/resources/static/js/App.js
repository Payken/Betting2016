/**
 * Created by fdarmoch on 2016-01-02.
 */
var app = angular.module("AIpro", []);

app.directive("manufacturer", [function () {
    return {
        scope: {
            manufacturer: '=',
        },


    };
}]);

app.directive("fileread", [function () {
    return {
        scope: {
            fileread: "="
        },
        link: function (scope, element, attributes) {
            element.bind("change", function (changeEvent) {
                var reader = new FileReader();
                reader.onload = function (loadEvent) {
                    scope.$apply(function () {
                        scope.fileread = loadEvent.target.result;
                    });
                }
                reader.readAsDataURL(changeEvent.target.files[0]);
            });
        }
    }
}]);
