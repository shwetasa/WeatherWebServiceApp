//package app.weather.service;
//
//import gov.usda.nrcs.wcc.awdbWebService.*;
//import javax.xml.namespace.QName;
//import java.net.URL;
//import java.math.BigDecimal;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//public class WSUseTryCases {
//	static final SimpleDateFormat dateFormat = new SimpleDateFormat(
//	        "yyyy-MM-dd");
//	    AwdbWebService m_webService = null;
//
//	/**
//	 * Constructor which initializes a web service instance.
//	 */
//
//	public WSUseTryCases()
//	{
//	    initWebService();
//	}   
//
//	/**
//	 * Initialize the web service member variable m_webService.
//	 */
//
//	private void initWebService()
//	{
//	    try
//	    {
//	    	    URL wsURL = new URL("https://wcc.sc.egov.usda.gov/awdbWebService/services?WSDL");
//			    AwdbWebService_Service lookup = new AwdbWebService_Service(wsURL, new 
//			    QName("http://www.wcc.nrcs.usda.gov/ns/awdbWebService", "AwdbWebService"));
//			    m_webService = lookup.getAwdbWebServiceImplPort();
//	    }
//	    catch (Exception e)
//	    {    
//	        System.out.println("Problem creating web service client: "
//	            + e.getMessage());   
//
//	    }    
//	}   
//
//	 /**
//	    * Example main program entry point which:
//	    * 1 - instantiates this class and creates a web service object
//	    * 2 - gets a list of stations, loop through the stations and print out each
//	    *     station's metadata
//	    * 3 - uses Use Case 3 to get last 7 days data for each station
//	    *     and print out each day's date and values. 
//	    * @param args
//	    */
//
//	    public static void main(String[] args){ 
//	        WSUseTryCases useCase = new WSUseTryCases();
//
//	        //Use Case 1: Get Inventory of Stations
//	        // NOTE:  For this tutorial, the selection criteria of 
//	        // network, state and element  are hard-coded 
//	        // as ‘SNTL’, ’OR’ and ’WTEQ’ in the getData function.
//	        // NOTE: The getStationMetadata*  function
//	        // may return some sites that do not have data 
//	        // the date range you are interested in.  
//	        // You can remove those stations by checking their 
//	        // begin and end dates before retrieving data.
//
//	        List<StationMetaData> metadata = useCase.getStations();
//
//	        String stationName, stationTriplet, beginDate, endDate, countyName, 
//	        huc, shefID, fipsCountryCode, fipsCountyCode, fipsStateNumber;
//
//	        BigDecimal elevation, latitude, longitude, stationDataTimeZone;
//
//	        // Loop through list of stations and retrieve and 
//	        // print out metadata for one station
//
//	        for (StationMetaData metadatum : metadata)
//	        {
//	            stationName = metadatum.getName();
//	            stationTriplet = metadatum.getStationTriplet();
//	            beginDate = metadatum.getBeginDate();
//	            endDate = metadatum.getEndDate();
//	            countyName = metadatum.getCountyName();
//	            elevation = metadatum.getElevation();
//	            huc = metadatum.getHuc();
//	            latitude = metadatum.getLatitude();
//	            longitude = metadatum.getLongitude();
//	            shefID = metadatum.getShefId();
//	            stationDataTimeZone = metadatum.getStationDataTimeZone();
//	            fipsCountryCode = metadatum.getFipsCountryCd();
//	            fipsCountyCode = metadatum.getFipsCountyCd();
//	            fipsStateNumber = metadatum.getFipsStateNumber();
//
//	        System.out.println("Station Name:       " + stationName + '\n' + 
//	                           "Station Triplet:    " + stationTriplet + '\n' +
//	                           "Begin Date:         " + beginDate + '\n' +
//	                           "End Date:           " + endDate + '\n' +
//	                           "County Name:        " + countyName + '\n' +
//	                           "Elevation:          " + elevation + '\n' +
//	                           "HUC:                " + huc + '\n' +
//	                           "Latitude:           " + latitude + '\n' +
//	                           "Longitude:          " + longitude + '\n' + 
//	                           "SHEF ID:            " + shefID + '\n' +
//	                           "Station Time Zone:  " + stationDataTimeZone + '\n' +
//	                           "Fips Country Code:  " + fipsCountryCode + '\n' +
//	                           "Fips County Code:   " + fipsCountyCode + '\n' +
//	                           "Fips State #:       " + fipsStateNumber);
//
//	            /*
//	             * Use Case 3: Get Last 7 Days Data for One Station
//	             * This will get DAILY data for each of the stations from 
//	             * Use Case 1. 
//	             * Note: To apply Use Case 2: Period of Record of Data for One Station,
//	             * see example method getPeriodOfRecord().
//	             */
//
//	            Data[] data = useCase.getLastSevenDaysData(stationTriplet);
//	            String beginDt = data[0].getBeginDate();
//	            String flags = data[0].getFlags().toString();
//	            BigDecimal[] stationValues = data[0].getValues().toArray(
//	                new BigDecimal[0]);
//	            // Get values for current station
//	            
//		            for (int i = 0; i <= stationValues.length-1; i++)
//		            {
//		                System.out.println("Date: Flags/Value: " + beginDt + ":  "
//		                    + flags + "/" + stationValues[i] + '\n');
//		            }
//	            
//	        }
//	    }
//	        
//	        /**
//	         * Use Case 1: Get Inventory of Stations
//	         * This example will get an inventory of all stations in Oregon 
//	         * for SNOTEL stations that have Snow Water Equivalent
//	         * and return  list of stations    
//	         */
//
//	        public List<StationMetaData> getStations(){
//	            List<String> stationIds = null;
//	            List<String> stateCds = null;
//	            List<String> networkCds = Arrays.asList("SNTL");
//	            List<String> hucs = null;
//	            List<String> countyNames = null;
//	            BigDecimal minLatitude = null;
//	            BigDecimal maxLatitude = null;
//	            BigDecimal minLongitude = null;
//	            BigDecimal maxLongitude = null;
//	            BigDecimal minElevation = null;
//	            BigDecimal maxElevation = null;
//	            List<String> elementCodes = Arrays.asList("WTEQ");
//	            List<Integer> ordinals = Arrays.asList(1);
//	            List<HeightDepth> heightDepths = null;
//
//	            /*
//	             * If (logicalAnd) is true, the getStations() call will return only 
//	             * stations that match ALL of the parameters passed in, otherwise it’ll 
//	             * return stations that match ANY of the parameters passed in.
//	             */       
//	           
//
//	            boolean logicalAnd = true;
//	            List<String> stationTriplets = m_webService.getStations(stationIds,
//	                stateCds, networkCds, hucs, countyNames, minLatitude,
//	                maxLatitude, minLongitude, maxLongitude, minElevation,
//	                maxElevation, elementCodes, ordinals, heightDepths, logicalAnd);
//	            List<StationMetaData> stations = m_webService
//	                .getStationMetadataMultiple(stationTriplets);
//	            return stations;
//	        }
//	        
//	        /**
//	         * Use Case 2: Get period of record for one station.
//	         * This will return period of Data that are SNOW WATER EQUIVALENT (element
//	         * code = WTEQ) for a given station and date range.
//	         * Note: Always use an ordinal of 1, and heightDepth of null 
//	         * (height depth is only used for soil sensors)
//	         * @param p_stationTriplet The station to get data for, ex: "471:ID:SNTL"
//	         * @param p_beginDate The begin date - a String format "yyyy-MM-dd"
//	         * @param p_endDate The end date - a String format "yyyy-MM-dd"
//	         * @return An Array of Data Objects
//	         */
//
//	        public Data[] getPeriodOfRecord(String p_stationTriplet, String p_beginDate,     String p_endDate){                
//	            Data[] values = m_webService.getData(Arrays.asList(p_stationTriplet),
//	                "WTEQ", 1, null, Duration.DAILY, true, p_beginDate, p_endDate, true)
//	                .toArray(new Data[0]);
//	            return values;
//	        }
//	        
//	        
//
//	        /**
//	            * Use Case 3: Get last seven days of data.
//	            * This will return the last seven days of SNOW WATER EQUIVALENT (element
//	            * code = WTEQ data, relative to today, for a given station. 
//	            * Note: Always use an ordinal of 1, and heightDepth of null 
//	            * (height depth is only used for soil sensors)     
//	            * @param p_stationTriplet The station to get data for, ex: "471:ID:SNTL"
//	            * @return An Array of Data Objects
//	            */
//
//	           public Data[] getLastSevenDaysData(String p_stationTriplet){
//
//	               String today = dateFormat.format(new Date());
//	               Calendar dayBefore = GregorianCalendar.getInstance();
//	               dayBefore.add(Calendar.DAY_OF_YEAR, -1);
//	               String sevenDaysAgo = dateFormat.format(dayBefore.getTime());
//
//	               Data[] values = m_webService.getData(Arrays.asList(p_stationTriplet),
//	                   "WTEQ", 1, null, Duration.DAILY, true, sevenDaysAgo, today, true)
//	                   .toArray(new Data[0]);
//
//	               return values;
//	            }
//	    }
