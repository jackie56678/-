docker run \
-p 3000:80 \
-d  \
--mount type=bind,source=D:/12952/Documents/8.项目实践类Programming/新学习/前后端项目复现/书本的增加删除/frontend/nginx,target=/etc/nginx/conf.d \
--mount type=bind,source=D:/12952/Documents/8.项目实践类Programming/新学习/前后端项目复现/书本的增加删除/frontend/dist,target=/usr/share/nginx/html \
nginx