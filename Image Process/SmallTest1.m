% I=imread('F:/test.jpg');
I=imread('F:/gakki.bmp');
% imtool(I);
subplot(221);
imshow(I);
% imwrite(I,'image1copy.jpg');

[K,map]=rgb2ind(I,256);
subplot(223);
imshow(K);
% imagesc(K);
colormap(map);

J=rgb2gray(I);
subplot(222);
imshow(J);

L=ind2rgb(K,map);
subplot(224);
imshow(L);
