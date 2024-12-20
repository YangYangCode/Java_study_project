import React, { useState, useEffect } from "react";
import { get_all_activitySchedule, get_AS_list_by_member_id } from "../../service/Service_AS";
import CardItem from "../../component/AS_CardItem";
import { Box, Button, Dialog, DialogActions, DialogContent, DialogTitle } from "@mui/material";

function ActivitySchedules({ isLoggedIn, userCret }) {

    const [activities, setActivities] = useState([]);       // 取得活動表
    const [signedAS, setSignedAS] = useState([]);           // 取得指定會員活動表

    const ASListData = async () => {
        try {
            const ASList = await get_all_activitySchedule();
            setActivities(ASList);  // 將活動資料儲存進狀態
        } catch (error) {
            console.error("Error getAllAS:", error);  // 若有錯誤會在這裡處理
        }
    };

    const SignASListData = async () => {
        if (!userCret?.id) return; // 如果 userCret.id 不存在，跳過請求
        try {
            const ASList = await get_AS_list_by_member_id(userCret.id);
            setSignedAS(ASList); // 儲存資料到狀態
        } catch (error) {
            console.error("Error getMemberSignedASList:", error); // 處理錯誤
        }
    };

    useEffect(() => {
        ASListData();  
        SignASListData(); 
    }, []);  


    const weekdays = ["星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"];        // 一周的日期映射

    const ActivitiesWithWeekday = activities.map((activity) => {        // 加入星期幾
        const date = new Date(activity.date);
        // console.log(date);
        const weekdayIndex = (date.getDay() + 6) % 7;  // 調整星期日為 6
        const weekdayName = weekdays[weekdayIndex];  // 取得正確的星期幾
        // console.log(weekdayName);
        return {
            ...activity,
            weekday: weekdayName  // 新增星期屬性
        };
    });

    // Modal
    const [isModalopen, setIsModalopen] = useState(false);  // 控制模態視窗開關
    const [modalContent, setModalContent] = useState('');  // 儲存模態視窗內容
    // 開啟模態視窗
    const handIsModalopen = (content) => {
        // console.log(content);
        setModalContent(content);
        setIsModalopen(true);
    };


    return (
        <div>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <div className="text-5xl font-bold mb-4 text-center">12/16 - 12/22 活動</div>

            {/* 按鈕部分 */}
            <br />
            <div className="flex justify-center">
                <div className="w-[90vw] flex justify-center gap-4 mb-6">
                    <button className="text-2xl font-bold border border-gray-300 rounded-lg px-4 py-2 ring-2 ring-gray-600 focus:ring-blue-500 transition-shadow">
                        上周活動
                    </button>
                    <button className="text-2xl font-bold border border-gray-300 rounded-lg px-4 py-2 ring-2 ring-gray-600 focus:ring-blue-500 transition-shadow">
                        下周活動
                    </button>
                </div>
            </div>
            <br />

            {isModalopen && (
                <Dialog open={isModalopen} onClose={() => setIsModalopen(false)}
                    fullWidth maxWidth="md">
                    <Box className="bg-white p-6 rounded shadow-lg text-center">
                        <DialogContent>
                            <Box>
                                <div>
                                    <h1 className="2xl px-4 py-2">活動資訊</h1>
                                    <br></br>
                                    <p>{modalContent}</p>
                                </div>
                            </Box>
                        </DialogContent>
                        <DialogActions>
                            <Button onClick={() => setIsModalopen(false)} color="primary" variant="contained" >
                                關閉
                            </Button>
                        </DialogActions>
                    </Box>
                </Dialog>
            )}

            <div className="min-h-screen flex justify-center">
                <div className="w-[90vw] flex justify-center space-y-6">
                    <div className="flex flex-wrap gap-6">
                        {weekdays.map((weekday) => {
                            // 根據 weekday 渲染活動列表
                            const dayActivities = ActivitiesWithWeekday.filter(activity => activity.weekday === weekday);

                            return (
                                <div key={weekday} className="w-full md:w-auto">
                                    {/* 星期標題 */}
                                    <h3 className="font-bold text-lg mb-4 text-center">{weekday}</h3>
                                    <div className="flex flex-col gap-4">
                                        {/* 如果有活動則垂直排列活動卡片，否則顯示「今日暫無活動」 */}
                                        {dayActivities.length > 0 ? (
                                            dayActivities.map((activity, index) => (
                                                <CardItem key={index} activity={activity}
                                                    isLoggedIn={isLoggedIn} userCret={userCret} signedAS={signedAS} 
                                                    handIsModalopen={handIsModalopen} SignASListData={SignASListData} />
                                            ))
                                        ) : (
                                            <span className="text-gray-500">今日暫無活動</span>
                                        )}
                                    </div>
                                </div>
                            );
                        })}
                    </div>
                </div>
            </div>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
        </div>
    );



}


export default ActivitySchedules;