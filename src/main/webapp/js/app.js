 var app = angular.module('App', ['ngRoute']);

 app.config(function($routeProvider) {
            $routeProvider
          .when('/books', {
            templateUrl: 'parts/books.html',
            controller: 'BooksController'
          })
          .when('/login', {
                  templateUrl: 'parts/login.html',
                  controller: 'LoginController'
          })
          .when('/authors', {
        	  templateUrl: 'parts/authors.html',
        	  controller: 'AuthorsController'
          })
          .when('/', {
                templateUrl: 'parts/home.html',
                controller: 'HomeController',
          })
          .otherwise({redirectTo:'/'});
});

/*`
app.config(['SessionService'], function($httpProvider, SessionService) {

    $httpProvider.interceptors.push(function($q) {
        return {
            request: function(config) {
                config.headers["Authorization"] = "Bearer: "+SessionService.token();
                return config;
            }
        };
    });

});
*/

app.run(function($rootScope, $location) {
    $rootScope.logout = function() {
    	$rootScope.token = null;
        $location.path('/');
    };
    
    $rootScope.user = window.localStorage.getItem("token");
});

            app.controller('HomeController', function() {});
            app.controller('LoginController', function($scope, $rootScope, $location, $http) {

                $scope.login = function() {
                    $http({
                        method: 'POST',
                        url: 'api/authenticate',
                        headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                        data: 'username='+$scope.username+'&password='+$scope.password
                        /*,
                        transformRequest: function(data, headers) {
                            console.log(data);
                            return data;
                        }*/
                    }).then(function(response) {
                        $rootScope.user = response.data;
                        $rootScope.token = response.data.login;
                        $location.path('/books');

                    }, function(response) {
                    });
                };
            });
            app.controller('BooksController', function($scope, $http, $rootScope, $location) {
                $http({
                    method: 'get',
                    url: 'api/books',
                    headers: {'Authorization': 'Bearer '+$rootScope.token}
                    })
                    .then(function(response) {
                        $scope.books = response.data;
                    }, function(response) {
                        if (response.status == 401) {
                            $location.path("/login");
                        }
                    });

                $scope.save = function(book) {
                    delete book.edit;
                    $http({
                        method: 'put',
                        url: 'api/books',
                        headers: {'Authorization': 'Bearer '+$rootScope.token},
                        data: book
                    }).then(function(response) {

                        book = response.data;
                        book.edit = false;

                    }, function(response) {
                        // TODO error
                    });
                };

                $scope.del = function(b, index) {
                    console.log("deleting "+index);
                    $http({
                        method: 'delete',
                        headers: {'Authorization': 'Bearer '+$rootScope.token},
                        url: 'api/books/'+b.id
                    }).then(function(response) {
                        // deleted
                        $scope.books.splice(index, 1);
                    }, function(response) {
                        // TODO error
                    });
                };
            });
app.controller('AuthorsController', function($scope, $http) {
	
	$scope.search = function(author) {
		$http({
			method: 'GET',
			url: 'api/authors/'+author+'/books'
		}).then(function(response) {
			$scope.books = response.data;
		}, function(response) {
			// FIXME manage error
		})
	}
	
});