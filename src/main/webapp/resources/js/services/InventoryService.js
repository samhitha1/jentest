agro.factory("InventoryService", function($http,$filter){
	var service = {
		getResource : function() {
			return 'inventory';
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
		loadProductTypes : function(){
			var certs = new Array("Processed","Raw");
		    return certs;
		    
		},		
	};
	return angular.extend(service, BaseService);
});