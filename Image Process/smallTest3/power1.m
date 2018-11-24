clc;
close all;
clear all; 
   
% -------------Gamma Transformations-----------------  
%f = imread('Fig0316(4)(bottom_left).tif');   
f = imread('test2.jpg');   
Gamma = 0.4;  
g2 = myExpEnhance(f,Gamma);  
 
figure();  
subplot(221);  imshow(f);  xlabel('a).Original Image');  
subplot(222),imhist(f),title('原图像直方图');%显示原始图像直方图  
subplot(223);  imshow(g2);  xlabel('b).Gamma Transformations \gamma = 0.4');  
subplot(224),imhist(g2),title('增强图像直方图');%显示原始图像直方图 
