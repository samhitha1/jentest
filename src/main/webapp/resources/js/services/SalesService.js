agro.factory("SalesService", function($http,$filter){
	var service = {
		getResource : function() {
			return 'sales';
		},
		
		getHttp : function() {
			return $http;
		},
		
		getBaseUrl : function() {
			return baseUrl;
		},
		getFormattedDate: function(date, format){
	    	return $filter('date')(date, format);
	    },
	    	 		
		loadCatagory : function(){
			var status = new Array("Grain","Pasta");
		    return status;
		    
		},
 		
		loadCertificates : function(){
			var certs = new Array("Organic","USDAC");
		    return certs;
		    
		},
	};
	return angular.extend(service, BaseService);
});