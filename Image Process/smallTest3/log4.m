clc;
close all;
clear all; 
%% -------------Log Transformations-----------------
f = rgb2gray(imread('test2.jpg'));
 
g_1 = myLogEnhance(f,10);
g_2 = myLogEnhance(f,100);
g_3 = myLogEnhance(f,200);
 
figure();
subplot(2,2,1);
imshow(f);xlabel('a).Original Image');
 
subplot(2,2,2);
imshow(g_1);xlabel('b).Log Transformations v=10');
 
subplot(2,2,3);
imshow(g_2);xlabel('c).Log Transformations v=100');
 
subplot(2,2,4);
imshow(g_3);
xlabel('d).Log Transformations v=200');
