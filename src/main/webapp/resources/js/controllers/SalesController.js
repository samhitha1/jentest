agro.controller('SalesController', ['$scope','$location','$window', '$state','SalesService','$filter',
     function($scope,$location, $window, $state,SalesService,$filter) {
		$scope.errors = [];
//		$scope.categories =InventoryService.loadCatagory();
//		$scope.certificates = InventoryService.loadCertificates();
//        $scope.convertGradesToSelect2Array = function(certs) {
//            return $.map( certs, function(cert) { return { "id":cert, "text":cert }; });
//        };
//		$scope.gradesSelector = {
//   	   			'placeholder': "Select...",
//   	   			'allowClear': true,
//   	   			'multiple': true,
//   	   	        'simple_tags': true,
//   	   	        'width' :'resolve',
//   	  	        'query': function (query) {
//   	  	            var data = { results: $scope.convertGradesToSelect2Array($scope.certificates) };
//   	  	            query.callback(data);
//   	  	        },
//   	  	        'id': function(select2Object) {  // retrieve a unique id from a select2 object
//   	  	            return select2Object.id; 
//   	  	        },
//                'setPristine': true
//   	   	};       
		$scope.createSale = function(sales){

			SalesService.save(sales).then(
				function(response) {
					$scope.errors = response.errors;
					if ($scope.errors.length == 0) {
						$scope.inventory = response.data;
//						$state.transitionTo("searchSchedule");
					}
			});
		};
		}
   	]);