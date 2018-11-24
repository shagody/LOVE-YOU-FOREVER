function dst_img=myHE(src_img)  
 
[height,width] = size(src_img);
dst_img=uint8(zeros(height,width));
%�������ػҶ�ͳ��;    
NumPixel = zeros(1,256);%ͳ�Ƹ��Ҷ���Ŀ����256���Ҷȼ�    
for i = 1:height    
    for j = 1: width    
        NumPixel(src_img(i,j) + 1) = NumPixel(src_img(i,j) + 1) + 1;%��Ӧ�Ҷ�ֵ���ص���������һ    
    end    
end    
%����Ҷȷֲ��ܶ�    
ProbPixel = zeros(1,256);    
for i = 1:256    
    ProbPixel(i) = NumPixel(i) / (height * width * 1.0);    
end    
%�����ۼ�ֱ��ͼ�ֲ�    
CumuPixel = zeros(1,256);    
for i = 1:256    
    if i == 1    
        CumuPixel(i) = ProbPixel(i);    
    else    
        CumuPixel(i) = CumuPixel(i - 1) + ProbPixel(i);    
    end    
end    
  
% ָ����Χ���о��⻯  
% pixel_max=max(max(I));  
% pixel_min=min(min(I));  
pixel_max=255;  
pixel_min=0;  
%�ԻҶ�ֵ����ӳ�䣨���⻯��    
for i = 1:height    
    for j = 1: width    
        dst_img(i,j) = CumuPixel(src_img(i,j)+1)*(pixel_max-pixel_min)+pixel_min;    
    end    
end    
return;
