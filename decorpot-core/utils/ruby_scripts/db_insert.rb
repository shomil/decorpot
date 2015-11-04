require 'rubygems'
require 'mysql2'
require 'csv'


puts "========DB INSERT OPERATION========"
puts "Password:"
password = gets.strip

client = Mysql2::Client.new(:host =>ENV["DB_LOCATION"], :username =>ENV["DB_USERNAME"],:port =>ENV["DB_PORT"], :password => password)

parent_data = CSV.read("data.csv",:encoding => 'windows-1251:utf-8',:headers=>true)

g_id = []

parent_data.each do |parent_row|
  if parent_row["Image_Id"] != nil
    price = parent_row['Base_Price'].split(',').join()
    statement = "INSERT INTO Decorpot.IMAGE_GROUP_ATTRIBUTE (IMAGE_TITLE, IMAGE_DESCRIPTION, IMAGE_PRICE, IMAGE_THEME, IMAGE_SPACE, BASEPRICE_DESCRIPTION,CREATED_DATE) VALUES ('#{parent_row['Image_Title']}','#{parent_row['Image_description']}','#{price}','#{parent_row['Theme']}','#{parent_row['Space']}','#{parent_row['BasePrice_Description']}','CURRENT_TIMESTAMP')"
    puts statement
    client.query(statement)
    statement2 = "SELECT Group_Id from Decorpot.IMAGE_GROUP_ATTRIBUTE where IMAGE_TITLE like '#{parent_row['Image_Title']}'"
    puts statement2
    client.query(statement2).each do |row|
      g_id << row['Group_Id']
    end
  end
end

grp_index =0
parent_data.each do |parent_row|
  view_id = 1
  input_view =[]
  if parent_row["Image_Id"] != nil
    statement = "INSERT INTO Decorpot.IMAGE_ATTRIBUTE (IMAGE_ID, IMAGE_COLOR, IMAGE_VIEW_ID, GROUP_ID, IMAGE_PATH_SMALL, IMAGE_PATH_MEDIUM, IMAGE_PATH_HD, IMAGE_CODE,CREATED_DATE) VALUES ('#{parent_row['Image_Id']}','Brown','#{view_id}','#{g_id[grp_index]}','#{parent_row['Image_Id']}.jpg','#{parent_row['Image_Id']}.jpg','#{parent_row['Image_Id']}.jpg','#{parent_row['Image_Id']}','CURRENT_TIMESTAMP')"
    puts "view 1 #{statement}"
    client.query(statement)
    if parent_row["Views"] != "0"
      input_view = parent_row["Views"].split(',')
      for i in 0..input_view.length-1
        view_id = view_id+1
        statement = "INSERT INTO Decorpot.IMAGE_ATTRIBUTE (IMAGE_ID, IMAGE_COLOR, IMAGE_VIEW_ID, GROUP_ID, IMAGE_PATH_SMALL, IMAGE_PATH_MEDIUM, IMAGE_PATH_HD, IMAGE_CODE,CREATED_DATE) VALUES ('#{input_view[i].strip}','Brown','#{view_id}','#{g_id[grp_index]}','#{input_view[i].strip}.jpg','#{input_view[i].strip}.jpg','#{input_view[i].strip}.jpg','#{input_view[i].strip}','CURRENT_TIMESTAMP')"
        puts "view #{view_id} #{statement}"
        client.query(statement)
      end
    end
    grp_index = grp_index+1
  end
end

grp_index = 0
max_aprt_id = 0
statement =  "Select max(aprt_group) from Decorpot.apartment_attribute"
client.query(statement).each do |row|
  max_aprt_id = row['max(aprt_group)']+1
end
parent_data.each do |parent_row|
  if parent_row["Image_Id"] != nil
    statement = "INSERT INTO Decorpot.apartment_attribute (aprt_group, apartment_name, group_id, image_id, bhk) VALUES ('#{max_aprt_id}','#{parent_row['Apartment_Name']}','#{g_id[grp_index]}','#{parent_row['Image_Id']}','#{parent_row['BHK']}')"
    puts statement
    client.query(statement)
    grp_index = grp_index+1
  end
end
