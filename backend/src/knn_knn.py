import time

# data science imports
import math
import numpy as np
import pandas as pd
from scipy.sparse import csr_matrix
from sklearn.neighbors import NearestNeighbors

# utils import
from fuzzywuzzy import fuzz
movies_filename = 'movies.csv'
ratings_filename = 'ratings.csv'
data_path = ''

df_movies = pd.read_csv(
    movies_filename,
    usecols=['movieId', 'title'],
    nrows=150000,
    dtype={'movieId': 'int32', 'title': 'str'})

df_ratings = pd.read_csv(
    ratings_filename,
    usecols=['userId', 'movieId', 'rating'],
    nrows=150000,
    dtype={'userId': 'int32', 'movieId': 'int32', 'rating': 'float32'})
num_users = len(df_ratings.userId.unique())
num_items = len(df_ratings.movieId.unique())
df_ratings_cnt_tmp = pd.DataFrame(df_ratings.groupby('rating').size(), columns=['count'])
# there are a lot more counts in rating of zero
total_cnt = num_users * num_items
rating_zero_cnt = total_cnt - df_ratings.shape[0]
# append counts of zero rating to df_ratings_cnt
df_ratings_cnt = df_ratings_cnt_tmp.append(
    pd.DataFrame({'count': rating_zero_cnt}, index=[0.0]),
    verify_integrity=True,
).sort_index()

df_movies = pd.read_csv(
    'movies.csv',
    usecols=['movieId', 'title'],
    nrows=150000,
    dtype={'movieId': 'int32', 'title': 'str'})

df_ratings = pd.read_csv(
    'ratings.csv',
    usecols=['userId', 'movieId', 'rating'],
    nrows=150000,
    dtype={'userId': 'int32', 'movieId': 'int32', 'rating': 'float32'})
df_tvs = pd.read_csv(
    'tv.csv',
    usecols=['tvId', 'title'],
    nrows=150000,
    dtype={'movieId': 'int32', 'title': 'str'})

df_ratings = pd.read_csv(
    'ratings.csv',
    usecols=['userId', 'movieId', 'rating'],
    nrows=150000,
    dtype={'userId': 'int32', 'movieId': 'int32', 'rating': 'float32'})
movie_to_idx = {
    movie: i for i, movie in
    enumerate(list(df_movies.set_index('movieId').loc[movie_user_mat.index].title))
}
df_ratings_cnt['log_count'] = np.log(df_ratings_cnt['count'])
df_movies_cnt = pd.DataFrame(df_ratings.groupby('movieId').size(), columns=['count'])
popularity_thres = 50
popular_movies = list(set(df_movies_cnt.query('count >= @popularity_thres').index))
df_ratings_drop_movies = df_ratings[df_ratings.movieId.isin(popular_movies)]

df_movies = pd.read_csv(
    'movies.csv',
    usecols=['movieId', 'title'],
    nrows=150000,
    dtype={'movieId': 'int32', 'title': 'str'})

df_ratings = pd.read_csv(
    'ratings.csv',
    usecols=['userId', 'movieId', 'rating'],
    nrows=150000,
    dtype={'userId': 'int32', 'movieId': 'int32', 'rating': 'float32'})
df_tvs = pd.read_csv(
    'tmdb_5000_movies.csv',
    usecols=['movieId', 'title'],
    nrows=150000,
    dtype={'movieId': 'int32', 'title': 'str'})

df_ratings = pd.read_csv(
    'ratings.csv',
    usecols=['userId', 'movieId', 'rating'],
    nrows=150000,
    dtype={'userId': 'int32', 'movieId': 'int32', 'rating': 'float32'})
model_knn=NearestNeighbors(metric='cosine', algorithm='brute', n_neighbors=10, n_jobs=-1)

df_users_cnt = pd.DataFrame(df_ratings_drop_movies.groupby('userId').size(), columns=['count'])
df_users_cnt.head()
ratings_thres = 20

movie_to_idx = {
    movie: i for i, movie in
    enumerate(list(df_movies.set_index('movieId').loc[movie_user_mat.index].title))
}
# transform matrix to scipy sparse matrix
movie_user_mat_sparse = csr_matrix(movie_user_mat.values)

# define model
# fit
model_knn.fit(movie_user_mat_sparse)
def recs(model_knn, data, mapper, fav_movie, n_recommendations):
    # inference
    print('Recommendation system start to make inference')
    print('......\n')
    if(idx is None):
        return
    else:
        distances, indices = model_knn.kneighbors(data[idx], n_neighbors=n_recommendations + 1)
           reverse_mapper = {v: k for k, v in mapper.items()}
    # print recommendations
        lista=''
        print('Recommendations for {}:'.format(fav_movie))
        for i, (idx, dist) in enumerate(raw_recommends):
            print('{0}: {1}, with distance of {2}'.format(i + 1, reverse_mapper[idx], dist))
            lista=lista+';'+reverse_mapper[idx]
            print (lista)
        return lista


make_recommendation(
    model_knn=model_knn,
    data=movie_user_mat_sparse,
    fav_movie=my_favorite,
    mapper=movie_to_idx,
    n_recommendations=5)