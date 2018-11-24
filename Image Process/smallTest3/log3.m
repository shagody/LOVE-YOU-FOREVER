I = rgb2gray(imread('test3.jpg'));  
figure;imshow(I);
J=double(I);
J=20*log(J+1);
J=uint8(J);
figure;imshow(J);
    