/*jshint smarttabs: true */

agro.directive('dateParser', function($filter){
	return {
		restrict: 'A',
		require: 'ngModel',
		link: function(scope, element, attrs,modelCtrl){
			   var dateValue = function(inputValue) {
		        	if(inputValue) {
			           var dateValued =  $filter('date')(inputValue, "yyyy-MM-dd");
			            modelCtrl.$setViewValue(dateValued);
			              modelCtrl.$render();
			           return dateValued;
		        	}
		         };
		         modelCtrl.$parsers.push(dateValue);
		         dateValue(scope[attrs.ngModel]);
		     }
	};
});
agro.directive('datepickerPopup', function (dateFilter, datepickerPopupConfig) {
    return {
        restrict: 'A',
        priority: 1,
        require: 'ngModel',
        link: function(scope, element, attr, ngModel) {
            var dateFormat = attr.datepickerPopup || datepickerPopupConfig.datepickerPopup;
            ngModel.$formatters.push(function (value) {
            	   var dateValued =  $filter('date')(value, "MM-dd-yyyy");
		    
		              modelCtrl.$setViewValue(dateValued);
		              modelCtrl.$render();
		    
                return dateFilter(value, dateFormat);
                
                
            });
        }
    };
});