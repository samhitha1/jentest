agro.controller('InvoiceController', ['$scope','$location','$window', '$state','InvoiceService','$window',
     function($scope,$location, $window, $state,InvoiceService,$window) {
		$scope.errors = [];
		$scope.invoiceNo;

		$scope.createInvoice = function(invoices){
		
			$window.open(baseUrl + "invoice.pdf?invoiceNo"+$scope.invoiceNo);	
		};
		}
   	]);