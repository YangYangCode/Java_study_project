import React from 'react';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';

const CardItem = () => {


    const f_data = [
        {
            id: 1, Name: "王教練", image: "Image"
        },
        {
            id: 2, Name: "陳教練", image: "Image"
        },
    ]

    return (
        <li>
                    {/* // 最小寬度 */}
            <Card sx={{ width:250 }}>
                <CardContent>
                    <Typography gutterBottom sx={{ color: 'text.secondary', fontSize: 14 }}>
                        {f_data[0].image}
                    </Typography>
                    {f_data[0].Name}
                </CardContent>
                <CardActions>
                    <Button size="small">預約表</Button>
                </CardActions>
            </Card>
        </li>
    );
};



export default CardItem;

