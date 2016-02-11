var timepicker = angular.module('ui.timepicker', [])

.value('uiTimepickerConfig', {
    'step' : 15,
    'maxTime':'11:45 PM',
    'timeFormat': 'h:i A',
    'scrollDefaultTime': "12:00 AM"
});

var baseUrl =  '';
if(document.getElementById('baseUrl')){
 baseUrl = document.getElementById('baseUrl').value;
}

var agro = angular.module('agro', ['ngRoute','ui.router','ui.bootstrap','ngCookies', 'ui.select2', 'ui.timepicker']);
agro.config(['$stateProvider','$routeProvider', '$provide','$httpProvider', function($stateProvider, $routeProvider, $provide, $httpProvider) {
	
	  //register the interceptor as a service
	  $provide.factory('myHttpInterceptor', function($q) {
			return {
		     'responseError': function(rejection) {
		    	if(rejection.status == 0){
		    		location.reload();
		    	}
		 	    return $q.reject(rejection);
		      }
		    };
	  	});
	  
	  $provide.factory('myHttpInterceptor', function($q) {
		  return function(promise) {
		    return promise.then(function(success) {
		      return success;
		    }, function(rejection) {
		    	if(rejection.status == 0){
		    		location.reload();
		    	}
		      return $q.reject(rejection);
		    });
		  };
		});
	  
	  $httpProvider.interceptors.push('myHttpInterceptor');
	  
$stateProvider
     .state('home', {
        url: "", // root route
        views: {
            "testregview": {
                templateUrl: 'resources/partials/home.html',
                controller: 'HomeController'
            }
        }
    })
    .state('inventory', {
    url: "/inventory", // root route
    views: {
        "testregview": {
            templateUrl: 'resources/partials/inventory-managment-form.html',
            controller: 'InventoryController'
        }
    }
    })
  .state('sales', {
    url: "/sales", // root route
    views: {
        "testregview": {
            templateUrl: 'resources/partials/sales-form.html',
            controller: 'SalesController'
        }
    }
    })
.state('invoice', {
    url: "/invoice", // root route
    views: {
        "testregview": {
            templateUrl: 'resources/partials/invoice-form.html',
            controller: 'InvoiceController'
        }
    }
    });
   }]);

