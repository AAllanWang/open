public static string Serialize<BusinessObject>(List<BusinessObject> GenericList)
         {
             XmlDocument result = new XmlDocument();
             result.LoadXml("<Root></Root>");
             foreach (BusinessObject obj in GenericList)
             {
                 XmlElement Item = result.CreateElement("Item");
                 PropertyInfo[] properties = obj.GetType().GetProperties();
                 foreach (PropertyInfo property in properties)
                 {
                     if (property.GetValue(obj, null) != null)
                     {
                         XmlElement element = result.CreateElement(property.Name);
                         element.SetAttribute("Type", property.PropertyType.Name);
                         element.InnerText = property.GetValue(obj, null).ToString();
                         Item.AppendChild(element);
                     }
                 }
                 result.DocumentElement.AppendChild(Item);
             }
             return result.InnerXml;
         }
		 
		 
		 

		 
public static List<BusinessObject> Deserialize<BusinessObject>(string XmlStr)
         {
             List<BusinessObject> result = new List<BusinessObject>();
             XmlDocument XmlDoc = new XmlDocument();
             XmlDoc.LoadXml(XmlStr);
             foreach (XmlNode ItemNode in XmlDoc.GetElementsByTagName("Root").Item(0).ChildNodes)
             {
                 BusinessObject item = Activator.CreateInstance<BusinessObject>();
                 PropertyInfo[] properties = typeof(BusinessObject).GetProperties();
                 foreach (XmlNode propertyNode in ItemNode.ChildNodes)
                 {
                     string name = propertyNode.Name;
                     string type = propertyNode.Attributes["Type"].Value;
                     string value = propertyNode.InnerXml;
                     foreach (PropertyInfo property in properties)
                     {
                         if (name == property.Name)
                         {
                             property.SetValue(item,Convert.ChangeType(value,property.PropertyType), null);
                         }
                     }
                 }
                 result.Add(item);
             }
             return result;
         }
		 
		 
		 
