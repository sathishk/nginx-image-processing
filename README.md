# Nginx Based Image Processing Server

Nginx Filters which can help optimize image delivery

# Usage

## Nginx
``` docker-compose up --build -d ```

## API (Spring Boot)

``` cd api && ./mvnw spring-boot:run```

# Image Operations

Image : http://localhost/images/1.jpeg  

Resized Image : http://localhost/images/_resize/320/320/1.jpeg  

Cropped Image : http://localhost/images/_crop/320/320/1.jpeg  

Rotate: http://localhost/images/_rotate/90/1.jpeg  


# Debug

See the Machine  :   
``` docker exec -it nginx bash``` 

Check If Image Module Exists : 

``` docker exec -it nginx ls -l /etc/nginx/modules/ | grep image``` 

Reload Nginx : 

``` docker exec -it nginx nginx -s reload``` 

# TODO
Should We build Custom Modules ?
1. Middleware for File Names
2. Ext Filter

# Caveats
https://github.com/spring-projects/spring-framework/issues/20807
https://serverfault.com/questions/811912/can-nginx-location-blocks-match-a-url-query-string

# Improvisation
1. Reduce Middleware
2. Open CV

# Reference
1. https://monicalent.com/blog/2019/01/06/responsive-images-with-nginx/
2. https://programmer.group/using-ngx_http_image_filter_module-of-nginx-to-make-real-time-picture-thumbnails.html
3. https://stackoverflow.com/questions/40574866/docker-nginx-ngx-http-image-filter-module
4. https://github.com/nginxinc/docker-nginx/tree/master/modules
