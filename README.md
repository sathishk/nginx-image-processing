# nginx-image-processing
Nginx Based Image Processing Server

# Image Operations

Image : http://localhost/images/1.jpeg
Resized Image : http://localhost/images/_resize/320/320/1.jpeg
Cropped Image : http://localhost/images/_crop/320/320/1.jpeg
Rotate: http://localhost/images/_rotate/90/1.jpeg


# Debug

See the Machine  : docker exec -it nginx bash

Check If Image Module Exists : docker exec -it nginx ls -l /etc/nginx/modules/ | grep image

Reload Nginx : docker exec -it nginx nginx -s reload

# Reference
https://monicalent.com/blog/2019/01/06/responsive-images-with-nginx/
https://programmer.group/using-ngx_http_image_filter_module-of-nginx-to-make-real-time-picture-thumbnails.html
https://stackoverflow.com/questions/40574866/docker-nginx-ngx-http-image-filter-module
https://github.com/nginxinc/docker-nginx/tree/master/modules
