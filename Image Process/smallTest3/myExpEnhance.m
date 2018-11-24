function dst_img=myExpEnhance(src_img,Gamma)  
src_img = mat2gray(src_img,[0 255]);%将图像矩阵A中介于amin和amax的数据归一化处理， 其余小于amin的元素都变为0， 大于amax的元素都变为1。  
C = 1;  
g2 = C*(src_img.^Gamma); 
%反归一化
max=255;
min=0;
dst_img=uint8(g2*(max-min)+min);
