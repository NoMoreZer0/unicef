import * as React from 'react';
import {useEffect, useState} from 'react';
import {styled} from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import Avatar from '@mui/material/Avatar';
import IconButton, {IconButtonProps} from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import {red} from '@mui/material/colors';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import MoreVertIcon from '@mui/icons-material/MoreVert';
import {Box, Button, Modal} from '@mui/material';
import {useForm} from 'react-hook-form';
import {FeedService} from '../../services/FeedService';
import {Post} from '../Post/Post';
import {PostContent} from '../../types';
import './NewsFeed.scss'
const style = {
  position: 'absolute' as 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 500,
  bgcolor: 'background.paper',
  border: '2px solid #000',
  boxShadow: 24,
  p: 4,
};

type Props = {};
type Inputs = {
  label: String,
  topic: String
}

export function NewsFeed(props: Props) {
  const [newsList, setNewsList] = useState([]);
  const [open, setOpen] = React.useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);
  const {register, handleSubmit, watch, formState: {errors}} = useForm<Inputs>({
  });

  const feedService = new FeedService();
  async function getNewsList() {
    const res = await feedService.getAllPosts();
    if (res) {
      setNewsList(res.reverse());
    }
  }


  const onSubmit = async dataNews => {
    console.log('hello')
    const response = await feedService.sendPost(dataNews)
    if (response) {
      console.log(response !== null);
      handleClose()
      alert("Новость успешно отправлена!");
      getNewsList();
    }
  };

  useEffect(() => {
    getNewsList();
  }, []);

  return (
    <>
      <div className="pt60 pb90">
        <div className="container">
          <div className="zagol mb20">Новостная лента</div>
          <Card sx={
            {
              display: 'flex',
              flexDirection: 'column',
              alignItems: 'center',
              justifyContent: 'center',
              boxShadow: 'none'
            }
          }>
            <Button onClick={handleOpen} variant="contained" sx={{
              marginBottom: '3rem',
              background: '#80C342',
              width: '25rem',
              height: '5rem',
              fontSize: '1.5rem'

            }} >
              + Добавить запись
            </Button>
            <Modal
              open={open}
              onClose={handleClose}
              aria-labelledby="modal-modal-title"
              aria-describedby="modal-modal-description"
            >
              <Box sx={style}>
                <form onSubmit={handleSubmit(onSubmit)}>
                  <label>Заголовок:</label><br></br>
                  <input type="text" {...register("label")} className="inputFields" /><br></br>
                  <br></br>
                  <label>Содержание:</label><br></br>
                  <input  {...register("topic")} className="inputFields" /><br></br>
                  <input type="submit"></input>
                </form>
              </Box>
            </Modal>
            {newsList.map((el, i) => (
              <Post postContent={el}></Post>
            ))}
          </Card>
        </div>
      </div>
    </>
  );
};