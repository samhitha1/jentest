agro.factory("InvoiceService", function($http,$filter){
	var service = {
		getResource : function() {
			return 'invoice';
		},
		
		getHttp : function() {
			return $http;
		},
		
		getBaseUrl : function() {
			return baseUrl;
		},
	
	};
	return angular.extend(service, BaseService);
});