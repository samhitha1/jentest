agro.controller('HomeController', ['$scope','$location','$window', '$state', 
     function HomeController($scope,$location, $window, $state) {
	    $scope.go = function(path){
	    	$location.path(path);
		};
	}
   ]);