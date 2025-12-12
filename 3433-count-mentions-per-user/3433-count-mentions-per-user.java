class Solution {
    public int[] countMentions(int n, List<List<String>> events) {
        int[] offline = new int[n];
        int[] res = new int[n];


        Collections.sort(events, (a, b)->{
            if(Integer.valueOf(a.get(1)).equals(Integer.valueOf(b.get(1)) )  )  return b.get(0).compareTo(a.get(0));
            return Integer.valueOf(a.get(1)).compareTo(Integer.valueOf(b.get(1)));
        });

        // System.out.println(events);

        for(int i=0; i<events.size();i++){
            Integer currTime = Integer.valueOf(events.get(i).get(1));
            for(int j=0; j<n; j++){
                if(offline[j] <= currTime)  offline[j] =0;
            }

            if("OFFLINE".equals(events.get(i).get(0))){
                // System.out.println("Adding to offline():" + Integer.valueOf(events.get(i).get(2)));
                offline[Integer.valueOf(events.get(i).get(2))] = currTime+60;
            }
            else{
                if("ALL".equals(events.get(i).get(2))){
                    for(int j=0;j<n; j++)   {
                        // System.out.println("Increasing: "+j);
                        res[j]+=1;
                    }
                }
                else if("HERE".equals(events.get(i).get(2))){
                    for(int j=0; j<n; j++){
                        // System.out.println("Increasing: "+j);
                        if(offline[j] == 0) res[j]+=1;
                    }
                }
                else{
                    String[] ids = events.get(i).get(2).split(" ");

                    for(int j=0; j<ids.length; j++){
                        // System.out.println("Increasing: "+ids[j].charAt(2));
                        res[Integer.valueOf(ids[j].substring(2))]+=1;
                    }

                }
            }
        }

        return res;

    }
}