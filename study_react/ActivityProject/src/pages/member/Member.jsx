import React, { useEffect, useState } from "react";
import BookingForm from "../../component/BookingForm";
import { get_AS_list_by_member_id, get_membe_by_id } from "../../service/Service_AS";


function Member() {

    const [member, setMember] = useState('');  // getMember
    const [ASListByMember, setASList] = useState('');  // getASListByMember

    // 更新member
    // useEffect(()=>{
    //     const memberData = get_membe_by_id(2);
    //     setMember(memberData);
    //     console.log(member);
    // },[]);

    useEffect(() => {
        const ASList = get_AS_list_by_member_id(1);
        console.log(ASList);
        setASList(ASList);
    }, []);



    return (

        <div className="min-h-screen flex justify-center">
            <div className="w-[90vw] p-4">
                <br></br>
                <br></br>
                <br></br>
                <div>
                    <h1 className="text-5xl font-bold mb-4 text-center">每周行事曆</h1>
                    <BookingForm />
                </div>
            </div>
        </div>
    )
}

export default Member;