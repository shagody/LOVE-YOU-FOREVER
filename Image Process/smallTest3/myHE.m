function dst_img=myHE(src_img)  
 
[height,width] = size(src_img);
dst_img=uint8(zeros(height,width));
%进行像素灰度统计;    
NumPixel = zeros(1,256);%统计各灰度数目，共256个灰度级    
for i = 1:height    
    for j = 1: width    
        NumPixel(src_img(i,j) + 1) = NumPixel(src_img(i,j) + 1) + 1;%对应灰度值像素点数量增加一    
    end    
end    
%计算灰度分布密度    
ProbPixel = zeros(1,256);    
for i = 1:256    
    ProbPixel(i) = NumPixel(i) / (height * width * 1.0);    
end    
%计算累计直方图分布    
CumuPixel = zeros(1,256);    
for i = 1:256    
    if i == 1    
        CumuPixel(i) = ProbPixel(i);    
    else    
        CumuPixel(i) = CumuPixel(i - 1) + ProbPixel(i);    
    end    
end    
  
% 指定范围进行均衡化  
% pixel_max=max(max(I));  
% pixel_min=min(min(I));  
pixel_max=255;  
pixel_min=0;  
%对灰度值进行映射（均衡化）    
for i = 1:height    
    for j = 1: width    
        dst_img(i,j) = CumuPixel(src_img(i,j)+1)*(pixel_max-pixel_min)+pixel_min;    
    end    
end    
return;
