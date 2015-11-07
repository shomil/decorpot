package com.decorpot.services;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decorpot.cache.DataCache;
import com.decorpot.repositories.DatabaseList;
import com.decorpot.repositories.DecorpotRepository;
import com.decorpot.repository.interfaces.ImageList;
import com.decorpot.repository.models.Image;
import com.decorpot.repository.models.ImageDetail;
import com.decorpot.repository.models.ImageGroup;

@Service
public class DecorpotServiceImpl implements DecorpotServices {

	private int defaultList = 10;
	// private String smallImageUrl =
	// "https://s3-ap-southeast-1.amazonaws.com/decorpot/low_image/";
	private String smallImageUrl = "https://s3-ap-southeast-1.amazonaws.com/decorpot/image_lot_small/";
	private String largeImageUrl = "https://s3-ap-southeast-1.amazonaws.com/decorpot/image_lot_large/";
	private String mediumImageUrl = "https://s3-ap-southeast-1.amazonaws.com/decorpot/image_lot_medium/";
	@Resource
	DecorpotRepository decorpotRepository;

	@Autowired
	ImageList imageList;

	@Override
	public List<Map<String, Object>> getDataBaseTables() {
		return decorpotRepository.getDatabaseName();
	}

	@Override
	public List<ImageDetail> getImageListSpace(String space, Integer toPrice,
			Integer fromPrice, Integer pageNum) {
		int to = pageNum * this.defaultList, from = (pageNum - 1)
				* this.defaultList + 1;

		String key = "getImageListSpace" + space;
		List<ImageDetail> images = null;
		if(DataCache.getInstance().get(key) == null){
			images = imageList.getImageListSpace(space, toPrice,
					fromPrice, to, from);

			for (ImageDetail image : images) {
				image.setPathSmall(smallImageUrl + image.getPathSmall());
			}
			DataCache.getInstance().put(key, images);
		}else{
			images = (List<ImageDetail>) DataCache.getInstance().get(key);
		}
		return images;
	}

	@Override
	public List<Map<String, Object>> getViewsByColors(String color, int groupid) {
		List<Map<String, Object>> images = imageList.getViewsByColors(color,
				groupid);
		for (Map<String, Object> image : images) {
			image.put("PATH_SMALL", smallImageUrl
					+ image.get("PATH_SMALL").toString());
			image.put("PATH_HD", largeImageUrl
					+ image.get("PATH_HD").toString());
		}
		return images;

	}

	@Override
	public List<Map<String, Object>> getColorsByGroup(int groupid) {
		// TODO Auto-generated method stub
		return imageList.getColorsByGroup(groupid);
	}

	@Override
	public List<Map<String, Object>> getImageListTheme(String theme,
			Integer toPrice, Integer fromPrice, Integer pageNum) {
		int to = pageNum * this.defaultList, from = (pageNum - 1)
				* this.defaultList + 1;
		List<Map<String, Object>> images = imageList.getImageListTheme(theme,
				toPrice, fromPrice, to, from);
		for (Map<String, Object> image : images) {
			image.put("PATH_SMALL", smallImageUrl
					+ image.get("PATH_SMALL").toString());
		}
		return images;
	}

	@Override
	public List<Map<String, Object>> getViewsByGroup(int groupid) {
		String key = "getViewsByGroup" + groupid;
		List<Map<String, Object>> images = null;

		if (DataCache.getInstance().get(key) == null) {
			images = imageList.getViewsByGroup(groupid);
			for (Map<String, Object> image : images) {
				image.put("IMAGE_PATH_SMALL", smallImageUrl
						+ image.get("IMAGE_PATH_SMALL").toString());
				image.put("IMAGE_PATH_MEDIUM", mediumImageUrl
						+ image.get("IMAGE_PATH_MEDIUM").toString());
				image.put("IMAGE_PATH_HD", largeImageUrl
						+ image.get("IMAGE_PATH_HD").toString());
			}
			DataCache.getInstance().put(key, images);
		} else {
			images = (List<Map<String, Object>>) DataCache.getInstance().get(
					key);
		}
		return images;
	}

	@Override
	public ImageGroup getImageGroupDetails(int groupId) {
		final String key = "getImageGroupDetails" + groupId;
		ImageGroup imageGroup = null;
		if(DataCache.getInstance().get(key) == null){
			imageGroup = imageList.getImageGroupDetails(groupId);
			DataCache.getInstance().put(key, imageGroup);
		}else{
			imageGroup = (ImageGroup) DataCache.getInstance().get(key);
		}
		return imageGroup;
	}

	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public List<Map<String, Object>> getPriceDetailByGroupId(int groupId) {
		final String key = "getPriceDetailByGroupId" + groupId;
		List<Map<String, Object>> groupPrice = null;
		if(DataCache.getInstance().get(key) == null){
			groupPrice = imageList.getPriceDetailByGroupId(groupId);
			DataCache.getInstance().put(key, groupPrice);
		}else{
			groupPrice = (List<Map<String, Object>>) DataCache.getInstance().get(key);
		}
		return groupPrice;
	}

}
